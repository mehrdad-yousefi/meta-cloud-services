#!/bin/bash

# Modify these variables as needed
ADMIN_PASSWORD=${ADMIN_PASSWORD:-password}
SERVICE_PASSWORD=${SERVICE_PASSWORD:-$ADMIN_PASSWORD}
DEMO_PASSWORD=${DEMO_PASSWORD:-$ADMIN_PASSWORD}
export OS_SERVICE_TOKEN="password"
export OS_SERVICE_ENDPOINT="http://localhost:35357/v2.0"
SERVICE_TENANT_NAME=${SERVICE_TENANT_NAME:-service}
#
MYSQL_USER=keystone
MYSQL_DATABASE=keystone
MYSQL_HOST=localhost
MYSQL_PASSWORD=password
#
KEYSTONE_REGION=RegionOne
KEYSTONE_HOST=localhost

# Shortcut function to get a newly generated ID
function get_field() {
    while read data; do
        if [ "$1" -lt 0 ]; then
            field="(\$(NF$1))"
        else
            field="\$$(($1 + 1))"
        fi
        echo "$data" | awk -F'[ \t]*\\|[ \t]*' "{print $field}"
    done
}

# Tenants
keystone tenant-get admin
if [ $? -eq 1 ]; then
    ADMIN_TENANT=$(keystone tenant-create --name=admin | grep " id " | get_field 2)
else
    ADMIN_TENANT=$(keystone tenant-get admin | grep " id " | get_field 2)
fi
keystone tenant-get demo
if [ $? -eq 1 ]; then
    DEMO_TENANT=$(keystone tenant-create --name=demo | grep " id " | get_field 2)
else
    DEMO_TENANT=$(keystone tenant-get demo | grep " id " | get_field 2)
fi
keystone tenant-get $SERVICE_TENANT_NAME
if [ $? -eq 1 ]; then
    SERVICE_TENANT=$(keystone tenant-create --name=$SERVICE_TENANT_NAME | grep " id " | get_field 2)
else
    SERVICE_TENANT=$(keystone tenant-get $SERVICE_TENANT_NAME | grep " id " | get_field 2)
fi

# Users
keystone user-get admin
if [ $? -eq 1 ]; then
    ADMIN_USER=$(keystone user-create --name=admin --pass="$ADMIN_PASSWORD" --email=admin@domain.com | grep " id " | get_field 2)
else
    ADMIN_USER=$(keystone user-get admin | grep " id " | get_field 2)
fi
keystone user-get demo
if [ $? -eq 1 ]; then                                                                                                                           
    DEMO_USER=$(keystone user-create --name=demo --pass="$DEMO_PASSWORD" --email=demo@domain.com --tenant-id=$DEMO_TENANT | grep " id " | get_field 2)
else
    DEMO_USER=$(keystone user-get demo | grep " id " | get_field 2)
fi
keystone user-get nova
if [ $? -eq 1 ]; then                                                                                                                           
    NOVA_USER=$(keystone user-create --name=nova --pass="$SERVICE_PASSWORD" --tenant-id $SERVICE_TENANT --email=nova@domain.com | grep " id " | get_field 2)
else
    NOVA_USER=$(keystone user-get nova | grep " id " | get_field 2)
fi
keystone user-get glance
if [ $? -eq 1 ]; then                                                                                                                           
    GLANCE_USER=$(keystone user-create --name=glance --pass="$SERVICE_PASSWORD" --tenant-id $SERVICE_TENANT --email=glance@domain.com | grep " id " | get_field 2)
else
    GLANCE_USER=$(keystone user-get glance | grep " id " | get_field 2)
fi
keystone user-get quantum
if [ $? -eq 1 ]; then                                                                                                                           
    QUANTUM_USER=$(keystone user-create --name=quantum --pass="$SERVICE_PASSWORD" --tenant-id $SERVICE_TENANT --email=quantum@domain.com | grep " id " | get_field 2)
else
    QUANTUM_USER=$(keystone user-get quantum | grep " id " | get_field 2)
fi
keystone user-get cinder
if [ $? -eq 1 ]; then                                                                                                                           
    CINDER_USER=$(keystone user-create --name=cinder --pass="$SERVICE_PASSWORD" --tenant-id $SERVICE_TENANT --email=cinder@domain.com | grep " id " | get_field 2)
else
    CINDER_USER=$(keystone user-get cinder | grep " id " | get_field 2)
fi

# Roles
keystone role-get admin
if [ $? -eq 1 ]; then
    ADMIN_ROLE=$(keystone role-create --name=admin | grep " id " | get_field 2)
else
    ADMIN_ROLE=$(keystone role-get admin | grep " id " | get_field 2)
fi
keystone role-get Member
if [ $? -eq 1 ]; then
    MEMBER_ROLE=$(keystone role-create --name=Member | grep " id " | get_field 2)
else
    MEMBER_ROLE=$(keystone role-get Member | grep " id " | get_field 2)
fi

# Add Roles to Users in Tenants
keystone user-role-list --user-id $ADMIN_USER --tenant-id $ADMIN_TENANT &> /dev/null
keystone user-role-add --tenant-id $ADMIN_TENANT --user-id $ADMIN_USER --role-id $ADMIN_ROLE

keystone user-role-list --user-id $NOVA_USER --tenant-id $SERVICE_TENANT &> /dev/null
keystone user-role-add --tenant-id $SERVICE_TENANT --user-id $NOVA_USER --role-id $ADMIN_ROLE

keystone user-role-list --user-id $GLANCE_USER --tenant-id $SERVICE_TENANT &> /dev/null
keystone user-role-add --tenant-id $SERVICE_TENANT --user-id $GLANCE_USER --role-id $ADMIN_ROLE

keystone user-role-list --user-id $QUANTUM_USER --tenant-id $SERVICE_TENANT &> /dev/null
keystone user-role-add --tenant-id $SERVICE_TENANT --user-id $QUANTUM_USER --role-id $ADMIN_ROLE

keystone user-role-list --user-id $CINDER_USER --tenant-id $SERVICE_TENANT &> /dev/null
keystone user-role-add --tenant-id $SERVICE_TENANT --user-id $CINDER_USER --role-id $ADMIN_ROLE

keystone user-role-list --user-id $DEMO_USER --tenant-id $DEMO_TENANT &> /dev/null
keystone user-role-add --tenant-id $DEMO_TENANT --user-id $DEMO_USER --role-id $MEMBER_ROLE

# Create services
COMPUTE_SERVICE=$(keystone service-create --name nova --type compute --description 'OpenStack Compute Service' | grep " id " | get_field 2)
VOLUME_SERVICE=$(keystone service-create --name cinder --type volume --description 'OpenStack Volume Service' | grep " id " | get_field 2)
IMAGE_SERVICE=$(keystone service-create --name glance --type image --description 'OpenStack Image Service' | grep " id " | get_field 2)
IDENTITY_SERVICE=$(keystone service-create --name keystone --type identity --description 'OpenStack Identity' | grep " id " | get_field 2)
EC2_SERVICE=$(keystone service-create --name ec2 --type ec2 --description 'OpenStack EC2 service' | grep " id " | get_field 2)
NETWORK_SERVICE=$(keystone service-create --name quantum --type network --description 'OpenStack Networking service' | grep " id " | get_field 2)

# Create endpoints
keystone endpoint-create --region $KEYSTONE_REGION --service-id $COMPUTE_SERVICE --publicurl 'http://'"$KEYSTONE_HOST"':8774/v2/$(tenant_id)s' --adminurl 'http://'"$KEYSTONE_HOST"':8774/v2/$(tenant_id)s' --internalurl 'http://'"$KEYSTONE_HOST"':8774/v2/$(tenant_id)s'
keystone endpoint-create --region $KEYSTONE_REGION --service-id $VOLUME_SERVICE --publicurl 'http://'"$KEYSTONE_HOST"':8776/v1/$(tenant_id)s' --adminurl 'http://'"$KEYSTONE_HOST"':8776/v1/$(tenant_id)s' --internalurl 'http://'"$KEYSTONE_HOST"':8776/v1/$(tenant_id)s'
keystone endpoint-create --region $KEYSTONE_REGION --service-id $IMAGE_SERVICE --publicurl 'http://'"$KEYSTONE_HOST"':9292/v2' --adminurl 'http://'"$KEYSTONE_HOST"':9292/v2' --internalurl 'http://'"$KEYSTONE_HOST"':9292/v2'
keystone endpoint-create --region $KEYSTONE_REGION --service-id $IDENTITY_SERVICE --publicurl 'http://'"$KEYSTONE_HOST"':5000/v2.0' --adminurl 'http://'"$KEYSTONE_HOST"':35357/v2.0' --internalurl 'http://'"$KEYSTONE_HOST"':5000/v2.0'
keystone endpoint-create --region $KEYSTONE_REGION --service-id $EC2_SERVICE --publicurl 'http://'"$KEYSTONE_HOST"':8773/services/Cloud' --adminurl 'http://'"$KEYSTONE_HOST"':8773/services/Admin' --internalurl 'http://'"$KEYSTONE_HOST"':8773/services/Cloud'
keystone endpoint-create --region $KEYSTONE_REGION --service-id $NETWORK_SERVICE --publicurl 'http://'"$KEYSTONE_HOST"':9696/' --adminurl 'http://'"$KEYSTONE_HOST"':9696/' --internalurl 'http://'"$KEYSTONE_HOST"':9696/'
