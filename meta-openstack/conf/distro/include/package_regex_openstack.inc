# package_regex_openstack.inc - This file contains data that tracks
# upstream project associated with a given recipe. This list is needed
# for recipes that version information can not be automagically discovered.
# As we automate this checking, this file will slowly be reduced.
#
# This data is used by the auto-upgrade-helper, to use it, you could
# add the following to your conf/local.conf:
#   --------------- snip ---------------
#   INHERIT =+ "distrodata"
#   require conf/distro/include/package_regex_openstack.inc
#   --------------- snip ---------------
#
# Fore more details about auto-upgrade-help, please refer to:
#   http://git.yoctoproject.org/cgit/cgit.cgi/auto-upgrade-helper/tree/README
#
# The format is as a bitbake variable override for each recipe
#
#       REGEX_URI:pn-<recipe name> = "recipe_url"
#	 - This is the url used by the package checking system to
#	   get the latest version of the package
#       REGEX:pn-<recipe name> = "package_regex"
#	 - This is the regex the package checking system uses to
#	   parse the page found at REGEX_URI:pn-<recipe name>
#

COMMON_REGEX = "(?P<pver>(\d+[\.-_]*)+)"

# PyPI sites
REGEX_URI:pn-python-cephclient = "https://pypi.python.org/pypi/python-cephclient/"
REGEX:pn-python-cephclient = "/python-cephclient/${COMMON_REGEX}"
REGEX_URI:pn-python-hp3parclient = "https://pypi.python.org/pypi/hp3parclient/"
REGEX:pn-python-hp3parclient = "/hp3parclient/${COMMON_REGEX}"
REGEX_URI:pn-python-openstackclient = "https://pypi.python.org/pypi/python-openstackclient/"
REGEX:pn-python-openstackclient = "/python-openstackclient/${COMMON_REGEX}"

REGEX_URI:pn-python3-alembic = "https://pypi.python.org/pypi/alembic"
REGEX:pn-python3-alembic = "/alembic/(?P<pver>\d+\.\d+\.\d+(\..*)?)"
REGEX_URI:pn-python3-amqp = "https://pypi.python.org/pypi/amqp"
REGEX:pn-python3-amqp = "/amqp/${COMMON_REGEX}"
REGEX_URI:pn-python3-babel = "https://pypi.python.org/pypi/Babel"
REGEX:pn-python3-babel = "/Babel/${COMMON_REGEX}"
REGEX_URI:pn-python-beautifulsoup4 = "https://pypi.python.org/pypi/beautifulsoup4"
REGEX:pn-python-beautifulsoup4 = "/beautifulsoup4/${COMMON_REGEX}"
REGEX_URI:pn-python-cephclient = "https://pypi.python.org/pypi/python-cephclient"
REGEX:pn-python-cephclient = "/python-cephclient/${COMMON_REGEX}"
REGEX_URI:pn-python3-cliff = "https://pypi.python.org/pypi/cliff"
REGEX:pn-python3-cliff = "/cliff/${COMMON_REGEX}"
REGEX_URI:pn-python-cmd2 = "https://pypi.python.org/pypi/cmd2"
REGEX:pn-python-cmd2 = "/cmd2/${COMMON_REGEX}"
REGEX_URI:pn-python-colorama = "https://pypi.python.org/pypi/colorama"
REGEX:pn-python-colorama = "/colorama/${COMMON_REGEX}"
REGEX_URI:pn-python3-coverage = "https://pypi.python.org/pypi/coverage"
REGEX:pn-python3-coverage = "/coverage/(?P<pver>\d+\.\d+(\.)?(a)?(\d)+)"
REGEX_URI:pn-python3-croniter = "https://pypi.python.org/pypi/croniter"
REGEX:pn-python3-croniter = "/croniter/${COMMON_REGEX}"
REGEX_URI:pn-python-cssselect = "https://pypi.python.org/pypi/cssselect"
REGEX:pn-python-cssselect = "/cssselect/${COMMON_REGEX}"
REGEX_URI:pn-python3-decorator = "https://pypi.python.org/pypi/decorator"
REGEX:pn-python3-decorator = "/decorator/${COMMON_REGEX}"
REGEX_URI:pn-python3-django = "https://pypi.python.org/pypi/Django"
REGEX:pn-python3-django = "/Django/${COMMON_REGEX}"
REGEX_URI:pn-python3-django-appconf = "https://pypi.python.org/pypi/django-appconf"
REGEX:pn-python3-django-appconf = "/django-appconf/${COMMON_REGEX}"
REGEX_URI:pn-python3-django-compressor = "https://pypi.python.org/pypi/django_compressor"
REGEX:pn-python3-django-compressor = "/django_compressor/${COMMON_REGEX}"
REGEX_URI:pn-python3-django-nose = "https://pypi.python.org/pypi/django-nose"
REGEX:pn-python3-django-nose = "/django-nose/${COMMON_REGEX}"
REGEX_URI:pn-python3-django-pyscss = "https://pypi.python.org/pypi/django-pyscss"
REGEX:pn-python3-django-pyscss = "/django-pyscss/${COMMON_REGEX}"
REGEX_URI:pn-python3-dogpile.cache = "https://pypi.python.org/pypi/dogpile.cache"
REGEX:pn-python3-dogpile.cache = "/dogpile.cache/${COMMON_REGEX}"
REGEX_URI:pn-python-dogpile.core = "https://pypi.python.org/pypi/dogpile.core"
REGEX:pn-python-dogpile.core = "/dogpile.core/${COMMON_REGEX}"
REGEX_URI:pn-python3-eventlet = "https://pypi.python.org/pypi/eventlet"
REGEX:pn-python3-eventlet = "/eventlet/${COMMON_REGEX}"
REGEX_URI:pn-python-extras = "https://pypi.python.org/pypi/extras"
REGEX:pn-python-extras = "/extras/${COMMON_REGEX}"
REGEX_URI:pn-python3-falcon = "https://pypi.python.org/pypi/falcon"
REGEX:pn-python3-falcon = "/falcon/${COMMON_REGEX}"
REGEX_URI:pn-python-fixtures = "https://pypi.python.org/pypi/fixtures"
REGEX:pn-python-fixtures = "/fixtures/${COMMON_REGEX}"
REGEX_URI:pn-python-flake8 = "https://pypi.python.org/pypi/flake8"
REGEX:pn-python-flake8 = "/flake8/${COMMON_REGEX}"
REGEX_URI:pn-python-futures = "https://pypi.python.org/pypi/futures"
REGEX:pn-python-futures = "/futures/${COMMON_REGEX}"
REGEX_URI:pn-python3-greenlet = "https://pypi.python.org/pypi/"
REGEX:pn-python3-greenlet = "//${COMMON_REGEX}"
REGEX_URI:pn-python3-happybase = "https://pypi.python.org/pypi/happybase"
REGEX:pn-python3-happybase = "/happybase/${COMMON_REGEX}"
REGEX_URI:pn-python-heat-cfntools = "https://pypi.python.org/pypi/heat-cfntools"
REGEX:pn-python-heat-cfntools = "/heat-cfntools/${COMMON_REGEX}"
REGEX_URI:pn-python-hgtools = "https://pypi.python.org/pypi/hgtools"
REGEX:pn-python-hgtools = "/hgtools/${COMMON_REGEX}"
REGEX_URI:pn-python-hp3parclient = "https://pypi.python.org/pypi/hp3parclient"
REGEX:pn-python-hp3parclient = "/hp3parclient/${COMMON_REGEX}"
REGEX_URI:pn-python-html5lib = "https://pypi.python.org/pypi/html5lib"
REGEX:pn-python-html5lib = "/html5lib/${COMMON_REGEX}"
REGEX_URI:pn-python3-httplib2 = "https://pypi.python.org/pypi/httplib2"
REGEX:pn-python3-httplib2 = "/httplib2/${COMMON_REGEX}"
REGEX_URI:pn-python-httpretty = "https://pypi.python.org/pypi/httpretty"
REGEX:pn-python-httpretty = "/httpretty/${COMMON_REGEX}"
REGEX_URI:pn-python-i18n = "https://pypi.python.org/pypi/python-i18n"
REGEX:pn-python-i18n = "/python-i18n/${COMMON_REGEX}"
REGEX_URI:pn-python3-iso8601 = "https://pypi.python.org/pypi/iso8601"
REGEX:pn-python3-iso8601 = "/iso8601/${COMMON_REGEX}"
REGEX_URI:pn-python3-jinja2 = "https://pypi.python.org/pypi/Jinja2"
REGEX:pn-python3-jinja2 = "/Jinja2/${COMMON_REGEX}"
REGEX_URI:pn-python-jsonpatch = "https://pypi.python.org/pypi/jsonpatch"
REGEX:pn-python-jsonpatch = "/jsonpatch/${COMMON_REGEX}"
REGEX_URI:pn-python3-jsonpath-rw = "https://pypi.python.org/pypi/jsonpath-rw"
REGEX:pn-python3-jsonpath-rw = "/jsonpath-rw/${COMMON_REGEX}"
REGEX_URI:pn-python-jsonpointer = "https://pypi.python.org/pypi/jsonpointer"
REGEX:pn-python-jsonpointer = "/jsonpointer/${COMMON_REGEX}"
REGEX_URI:pn-python3-jsonschema = "https://pypi.python.org/pypi/jsonschema"
REGEX:pn-python3-jsonschema = "/jsonschema/${COMMON_REGEX}"
REGEX_URI:pn-python-kazoo = "https://pypi.python.org/pypi/kazoo"
REGEX:pn-python-kazoo = "/kazoo/${COMMON_REGEX}"
REGEX_URI:pn-python-keyring = "https://pypi.python.org/pypi/keyring"
REGEX:pn-python-keyring = "/keyring/${COMMON_REGEX}"
REGEX_URI:pn-python3-kombu = "https://pypi.python.org/pypi/kombu"
REGEX:pn-python3-kombu = "/kombu/${COMMON_REGEX}"
REGEX_URI:pn-python3-lesscpy = "https://pypi.python.org/pypi/lesscpy"
REGEX:pn-python3-lesscpy = "/lesscpy/${COMMON_REGEX}"
REGEX_URI:pn-python3-lockfile = "https://pypi.python.org/pypi/lockfile"
REGEX:pn-python3-lockfile = "/lockfile/${COMMON_REGEX}"
REGEX_URI:pn-python-logutils = "https://pypi.python.org/pypi/logutils"
REGEX:pn-python-logutils = "/logutils/${COMMON_REGEX}"
REGEX_URI:pn-python3-lxml = "https://pypi.python.org/pypi/lxml"
REGEX:pn-python3-lxml = "/lxml/${COMMON_REGEX}"
REGEX_URI:pn-python-mako = "https://pypi.python.org/pypi/Mako"
REGEX:pn-python-mako = "/Mako/${COMMON_REGEX}"
REGEX_URI:pn-python-markupsafe = "https://pypi.python.org/pypi/MarkupSafe"
REGEX:pn-python-markupsafe = "/MarkupSafe/${COMMON_REGEX}"
REGEX_URI:pn-python-mccabe = "https://pypi.python.org/pypi/mccabe"
REGEX:pn-python-mccabe = "/mccabe/${COMMON_REGEX}"
REGEX_URI:pn-python-memcache = "https://pypi.python.org/pypi/pymemcache"
REGEX:pn-python-memcache = "/pymemcache/${COMMON_REGEX}"
REGEX_URI:pn-python3-memcached = "https://pypi.python.org/pypi/"
REGEX:pn-python3-memcached = "//${COMMON_REGEX}"
REGEX_URI:pn-python-mimeparse = "https://pypi.python.org/pypi/python-mimeparse"
REGEX:pn-python-mimeparse = "/python-mimeparse/${COMMON_REGEX}"
REGEX_URI:pn-python3-mock = "https://pypi.python.org/pypi/mock"
REGEX:pn-python3-mock = "/mock/${COMMON_REGEX}"
REGEX_URI:pn-python-mox = "https://pypi.python.org/pypi/mox"
REGEX:pn-python-mox = "/mox/${COMMON_REGEX}"
REGEX_URI:pn-python3-mox3 = "https://pypi.python.org/pypi/mox3"
REGEX:pn-python3-mox3 = "/mox3/${COMMON_REGEX}"
REGEX_URI:pn-python3-msgpack = "https://pypi.python.org/pypi/msgpack-python"
REGEX:pn-python3-msgpack = "/msgpack-python/${COMMON_REGEX}"
REGEX_URI:pn-python3-netaddr = "https://pypi.python.org/pypi/netaddr"
REGEX:pn-python3-netaddr = "/netaddr/${COMMON_REGEX}"
REGEX_URI:pn-python3-netifaces = "https://pypi.python.org/pypi/netifaces"
REGEX:pn-python3-netifaces = "/netifaces/${COMMON_REGEX}"
REGEX_URI:pn-python-networkx = "https://pypi.python.org/pypi/networkx"
REGEX:pn-python-networkx = "/networkx/${COMMON_REGEX}"
REGEX_URI:pn-python-nose-exclude = "https://pypi.python.org/pypi/nose-exclude"
REGEX:pn-python-nose-exclude = "/nose-exclude/${COMMON_REGEX}"
REGEX_URI:pn-python-oauth2 = "https://pypi.python.org/pypi/oauth2"
REGEX:pn-python-oauth2 = "/oauth2/${COMMON_REGEX}"
REGEX_URI:pn-python-openstackclient = "https://pypi.python.org/pypi/python-openstackclient"
REGEX:pn-python-openstackclient = "/python-openstackclient/${COMMON_REGEX}"
REGEX_URI:pn-python-openstack-nose = "https://pypi.python.org/pypi/openstack.nose_plugin"
REGEX:pn-python-openstack-nose = "/openstack.nose_plugin/${COMMON_REGEX}"
REGEX_URI:pn-python3-oslo.concurrency = "https://pypi.python.org/pypi/oslo.concurrency"
REGEX:pn-python3-oslo.concurrency = "/oslo.concurrency/${COMMON_REGEX}"
REGEX_URI:pn-python3-oslo.config = "https://pypi.python.org/pypi/oslo.config"
REGEX:pn-python3-oslo.config = "/oslo.config/${COMMON_REGEX}"
REGEX_URI:pn-python3-oslo.db = "https://pypi.python.org/pypi/oslo.db"
REGEX:pn-python3-oslo.db = "/oslo.db/${COMMON_REGEX}"
REGEX_URI:pn-python3-oslo.i18n = "https://pypi.python.org/pypi/oslo.i18n"
REGEX:pn-python3-oslo.i18n = "/oslo.i18n/${COMMON_REGEX}"
REGEX_URI:pn-python3-oslo.middleware = "https://pypi.python.org/pypi/oslo.middleware"
REGEX:pn-python3-oslo.middleware = "/oslo.middleware/${COMMON_REGEX}"
REGEX_URI:pn-python3-oslo.rootwrap = "https://pypi.python.org/pypi/oslo.rootwrap"
REGEX:pn-python3-oslo.rootwrap = "/oslo.rootwrap/${COMMON_REGEX}"
REGEX_URI:pn-python-oslotest = "https://pypi.python.org/pypi/oslotest"
REGEX:pn-python-oslotest = "/oslotest/${COMMON_REGEX}"
REGEX_URI:pn-python3-osprofiler = "https://pypi.python.org/pypi/osprofiler"
REGEX:pn-python3-osprofiler = "/osprofiler/${COMMON_REGEX}"
REGEX_URI:pn-python-pam = "https://pypi.python.org/pypi/pam"
REGEX:pn-python-pam = "/pam/${COMMON_REGEX}"
REGEX_URI:pn-python3-paramiko = "https://pypi.python.org/pypi/paramiko"
REGEX:pn-python3-paramiko = "/paramiko/${COMMON_REGEX}"
REGEX_URI:pn-python3-passlib = "https://pypi.python.org/pypi/passlib"
REGEX:pn-python3-passlib = "/passlib/${COMMON_REGEX}"
REGEX_URI:pn-python3-paste = "https://pypi.python.org/pypi/Paste"
REGEX:pn-python3-paste = "/Paste/${COMMON_REGEX}"
REGEX_URI:pn-python3-pastedeploy = "https://pypi.python.org/pypi/PasteDeploy"
REGEX:pn-python3-pastedeploy = "/PasteDeploy/${COMMON_REGEX}"
REGEX_URI:pn-python3-pbr = "https://pypi.python.org/pypi/pbr"
REGEX:pn-python3-pbr = "/pbr/${COMMON_REGEX}"
REGEX_URI:pn-python3-pecan = "https://pypi.python.org/pypi/pecan"
REGEX:pn-python3-pecan = "/pecan/${COMMON_REGEX}"
REGEX_URI:pn-python-pep8 = "https://pypi.python.org/pypi/pep8"
REGEX:pn-python-pep8 = "/pep8/${COMMON_REGEX}"
REGEX_URI:pn-python3-pexpect = "https://pypi.python.org/pypi/pexpect"
REGEX:pn-python3-pexpect = "/pexpect/${COMMON_REGEX}"
REGEX_URI:pn-python3-pint = "https://pypi.python.org/pypi/Pint"
REGEX:pn-python3-pint = "/Pint/${COMMON_REGEX}"
REGEX_URI:pn-python3-ply = "https://pypi.python.org/pypi/ply"
REGEX:pn-python3-ply = "/ply/${COMMON_REGEX}"
REGEX_URI:pn-python-posix-ipc = "https://pypi.python.org/pypi/posix_ipc"
REGEX:pn-python-posix-ipc = "/posix_ipc/${COMMON_REGEX}"
REGEX_URI:pn-python3-prettytable = "https://pypi.python.org/pypi/prettytable"
REGEX:pn-python3-prettytable = "/prettytable/${COMMON_REGEX}"
REGEX_URI:pn-python-psycopg2 = "https://pypi.python.org/pypi/psycopg2"
REGEX:pn-python-psycopg2 = "/psycopg2/${COMMON_REGEX}"
REGEX_URI:pn-python-py = "https://pypi.python.org/pypi/py"
REGEX:pn-python-py = "/py/${COMMON_REGEX}"
REGEX_URI:pn-python-pyasn1 = "https://pypi.python.org/pypi/pyasn1"
REGEX:pn-python-pyasn1 = "/pyasn1/${COMMON_REGEX}"
REGEX_URI:pn-python3-pycadf = "https://pypi.python.org/pypi/pycadf"
REGEX:pn-python3-pycadf = "/pycadf/${COMMON_REGEX}"
REGEX_URI:pn-python3-pycryptodome = "https://pypi.python.org/pypi/pycryptodome"
REGEX:pn-python3-pycryptodome = "/pycryptodome/${COMMON_REGEX}"
REGEX_URI:pn-python-pyflakes = "https://pypi.python.org/pypi/pyflakes"
REGEX:pn-python-pyflakes = "/pyflakes/${COMMON_REGEX}"
REGEX_URI:pn-python3-pymongo = "https://pypi.python.org/pypi/pymongo"
REGEX:pn-python3-pymongo = "/pymongo/${COMMON_REGEX}"
REGEX_URI:pn-python3-pyparsing = "https://pypi.python.org/pypi/pyparsing"
REGEX:pn-python3-pyparsing = "/pyparsing/${COMMON_REGEX}"
REGEX_URI:pn-python3-pysaml2 = "https://pypi.python.org/pypi/pysaml2"
REGEX:pn-python3-pysaml2 = "/pysaml2/${COMMON_REGEX}"
REGEX_URI:pn-python3-pyscss = "https://pypi.python.org/pypi/pyScss"
REGEX:pn-python3-pyscss = "/pyScss/${COMMON_REGEX}"
REGEX_URI:pn-python3-pysnmp = "https://pypi.python.org/pypi/pysnmp"
REGEX:pn-python3-pysnmp = "/pysnmp/${COMMON_REGEX}"
REGEX_URI:pn-python-pytest = "https://pypi.python.org/pypi/pytest"
REGEX:pn-python-pytest = "/pytest/${COMMON_REGEX}"
REGEX_URI:pn-python3-pytz = "https://pypi.python.org/pypi/pytz"
REGEX:pn-python3-pytz = "/pytz/${COMMON_REGEX}"
REGEX_URI:pn-python-pyudev = "https://pypi.python.org/pypi/pyudev"
REGEX:pn-python-pyudev = "/pyudev/${COMMON_REGEX}"
REGEX_URI:pn-python3-retrying = "https://pypi.python.org/pypi/retrying"
REGEX:pn-python3-retrying = "/retrying/${COMMON_REGEX}"
REGEX_URI:pn-python3-rfc3986 = "https://pypi.python.org/pypi/rfc3986"
REGEX:pn-python3-rfc3986 = "/rfc3986/${COMMON_REGEX}"
REGEX_URI:pn-python3-routes = "https://pypi.python.org/pypi/Routes"
REGEX:pn-python3-routes = "/Routes/${COMMON_REGEX}"
REGEX_URI:pn-python3-rtslib-fb = "https://pypi.python.org/pypi/rtslib-fb"
REGEX:pn-python3-rtslib-fb = "/rtslib-fb/${COMMON_REGEX}"
REGEX_URI:pn-python-setuptools-git = "https://pypi.python.org/pypi/setuptools-git"
REGEX:pn-python-setuptools-git = "/setuptools-git/${COMMON_REGEX}"
REGEX_URI:pn-python3-simplegeneric = "https://pypi.python.org/pypi/simplegeneric"
REGEX:pn-python3-simplegeneric = "/simplegeneric/${COMMON_REGEX}"
REGEX_URI:pn-python3-singledispatch = "https://pypi.python.org/pypi/singledispatch"
REGEX:pn-python3-singledispatch = "/singledispatch/${COMMON_REGEX}"
REGEX_URI:pn-python3-sqlalchemy-migrate = "https://pypi.python.org/pypi/sqlalchemy-migrate"
REGEX:pn-python3-sqlalchemy-migrate = "/sqlalchemy-migrate/${COMMON_REGEX}"
REGEX_URI:pn-python3-stevedore = "https://pypi.python.org/pypi/stevedore"
REGEX:pn-python3-stevedore = "/stevedore/${COMMON_REGEX}"
REGEX_URI:pn-python-subunit = "https://pypi.python.org/pypi/python-subunit"
REGEX:pn-python-subunit = "/python-subunit/${COMMON_REGEX}"
REGEX_URI:pn-python-sysv-ipc = "https://pypi.python.org/pypi/sysv_ipc"
REGEX:pn-python-sysv-ipc = "/sysv_ipc/${COMMON_REGEX}"
REGEX_URI:pn-python-tempita = "https://pypi.python.org/pypi/Tempita"
REGEX:pn-python-tempita = "/Tempita/(?P<pver>\d+\.\d+\.\d((\w)*)?)"
REGEX_URI:pn-python-termcolor = "https://pypi.python.org/pypi/termcolor"
REGEX:pn-python-termcolor = "/termcolor/${COMMON_REGEX}"
REGEX_URI:pn-python-testrepository = "https://pypi.python.org/pypi/testrepository"
REGEX:pn-python-testrepository = "/testrepository/${COMMON_REGEX}"
REGEX_URI:pn-python-testresources = "https://pypi.python.org/pypi/testresources"
REGEX:pn-python-testresources = "/testresources/${COMMON_REGEX}"
REGEX_URI:pn-python3-testscenarios = "https://pypi.python.org/pypi/testscenarios"
REGEX:pn-python3-testscenarios = "/testscenarios/${COMMON_REGEX}"
REGEX_URI:pn-python-testtools = "https://pypi.python.org/pypi/testtools"
REGEX:pn-python-testtools = "/testtools/${COMMON_REGEX}"
REGEX_URI:pn-python3-thrift = "https://pypi.python.org/pypi/thrift"
REGEX:pn-python3-thrift = "/thrift/${COMMON_REGEX}"
REGEX_URI:pn-python-tooz = "https://pypi.python.org/pypi/tooz"
REGEX:pn-python-tooz = "/tooz/${COMMON_REGEX}"
REGEX_URI:pn-python-tox = "https://pypi.python.org/pypi/tox"
REGEX:pn-python-tox = "/tox/${COMMON_REGEX}"
REGEX_URI:pn-python-virtualenv = "https://pypi.python.org/pypi/virtualenv"
REGEX:pn-python-virtualenv = "/virtualenv/${COMMON_REGEX}"
REGEX_URI:pn-python3-waitress = "https://pypi.python.org/pypi/waitress"
REGEX:pn-python3-waitress = "/waitress/${COMMON_REGEX}"
REGEX_URI:pn-python3-warlock = "https://pypi.python.org/pypi/warlock"
REGEX:pn-python3-warlock = "/warlock/${COMMON_REGEX}"
REGEX_URI:pn-python3-websockify = "https://pypi.python.org/pypi/websockify"
REGEX:pn-python3-websockify = "/websockify/${COMMON_REGEX}"
REGEX_URI:pn-python3-webtest = "https://pypi.python.org/pypi/WebTest"
REGEX:pn-python3-webtest = "/WebTest/${COMMON_REGEX}"
REGEX_URI:pn-python3-wsme = "https://pypi.python.org/pypi/WSME"
REGEX:pn-python3-wsme = "/WSME/${COMMON_REGEX}"
REGEX_URI:pn-python3-xattr = "https://pypi.python.org/pypi/xattr"
REGEX:pn-python3-xattr = "/xattr/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic = "https://pypi.python.org/pypi/XStatic"
REGEX:pn-python3-xstatic = "/XStatic/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-angular = "https://pypi.python.org/pypi/XStatic-Angular"
REGEX:pn-python3-xstatic-angular = "/XStatic-Angular/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-angular-bootstrap = "https://pypi.python.org/pypi/XStatic-Angular-Bootstrap"
REGEX:pn-python3-xstatic-angular-bootstrap = "/XStatic-Angular-Bootstrap/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-angular-cookies = "https://pypi.python.org/pypi/XStatic-Angular-Cookies"
REGEX:pn-python3-xstatic-angular-cookies = "/XStatic-Angular-Cookies/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-angular-mock = "https://pypi.python.org/pypi/XStatic-Angular-Mock"
REGEX:pn-python3-xstatic-angular-mock = "/XStatic-Angular-Mock/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-bootstrap-datepicker = "https://pypi.python.org/pypi/XStatic-Bootstrap-Datepicker"
REGEX:pn-python3-xstatic-bootstrap-datepicker = "/XStatic-Bootstrap-Datepicker/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-bootstrap-scss = "https://pypi.python.org/pypi/XStatic-Bootstrap-SCSS"
REGEX:pn-python3-xstatic-bootstrap-scss = "/XStatic-Bootstrap-SCSS/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-d3 = "https://pypi.python.org/pypi/XStatic-D3"
REGEX:pn-python3-xstatic-d3 = "/XStatic-D3/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-font-awesome = "https://pypi.python.org/pypi/XStatic-Font-Awesome"
REGEX:pn-python3-xstatic-font-awesome = "/XStatic-Font-Awesome/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-hogan = "https://pypi.python.org/pypi/XStatic-Hogan"
REGEX:pn-python3-xstatic-hogan = "/XStatic-Hogan/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-jasmine = "https://pypi.python.org/pypi/XStatic-Jasmine"
REGEX:pn-python3-xstatic-jasmine = "/XStatic-Jasmine/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-jquery = "https://pypi.python.org/pypi/XStatic-jQuery"
REGEX:pn-python3-xstatic-jquery = "/XStatic-jQuery/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-jquery-migrate = "https://pypi.python.org/pypi/XStatic-JQuery-Migrate"
REGEX:pn-python3-xstatic-jquery-migrate = "/XStatic-JQuery-Migrate/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-jquery-quicksearch = "https://pypi.python.org/pypi/XStatic-JQuery.quicksearch"
REGEX:pn-python3-xstatic-jquery-quicksearch = "/XStatic-JQuery.quicksearch/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-jquery-tablesorter = "https://pypi.python.org/pypi/XStatic-JQuery.TableSorter"
REGEX:pn-python3-xstatic-jquery-tablesorter = "/XStatic-JQuery.TableSorter/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-jquery-ui = "https://pypi.python.org/pypi/XStatic-jquery-ui"
REGEX:pn-python3-xstatic-jquery-ui = "/XStatic-jquery-ui/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-jsencrypt = "https://pypi.python.org/pypi/XStatic-JSEncrypt"
REGEX:pn-python3-xstatic-jsencrypt = "/XStatic-JSEncrypt/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-qunit = "https://pypi.python.org/pypi/XStatic-QUnit"
REGEX:pn-python3-xstatic-qunit = "/XStatic-QUnit/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-rickshaw = "https://pypi.python.org/pypi/XStatic-Rickshaw"
REGEX:pn-python3-xstatic-rickshaw = "/XStatic-Rickshaw/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-smart-table = "https://pypi.python.org/pypi/XStatic-smart-table"
REGEX:pn-python3-xstatic-smart-table = "/XStatic-smart-table/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-spin = "https://pypi.python.org/pypi/XStatic-Spin"
REGEX:pn-python3-xstatic-spin = "/XStatic-Spin/${COMMON_REGEX}"
REGEX_URI:pn-python3-xstatic-term.js = "https://pypi.python.org/pypi/XStatic-term.js"
REGEX:pn-python3-xstatic-term.js = "/XStatic-term.js/${COMMON_REGEX}"
REGEX_URI:pn-python-zake = "https://pypi.python.org/pypi/zake"
REGEX:pn-python-zake = "/zake/${COMMON_REGEX}"

# GIT
GITTAGREGEX_COMMON = "(?P<pver>\d+\.\d+\.(\d\.?)*)"

GITTAGREGEX:pn-python-glanceclient = "${GITTAGREGEX_COMMON}"
GITTAGREGEX:pn-python3-keystoneclient = "${GITTAGREGEX_COMMON}"
GITTAGREGEX:pn-python-neutronclient = "(?P<pver>\d+\.\d+\.(\d\.?)+)"
GITTAGREGEX:pn-python-novaclient = "${GITTAGREGEX_COMMON}"

GITTAGREGEX_BETA = "(?P<pver>\d+\.\d+(\.\d+(b\d)?)?)"
GITTAGREGEX:pn-python-barbican = "${GITTAGREGEX_BETA}"
GITTAGREGEX:pn-python-ceilometer = "${GITTAGREGEX_BETA}"
GITTAGREGEX:pn-python-cinder = "${GITTAGREGEX_BETA}"
GITTAGREGEX:pn-python-glance = "${GITTAGREGEX_BETA}"
GITTAGREGEX:pn-python-heat = "${GITTAGREGEX_BETA}"
GITTAGREGEX:pn-python-horizon = "${GITTAGREGEX_BETA}"
GITTAGREGEX:pn-python-keystone = "${GITTAGREGEX_BETA}"
GITTAGREGEX:pn-python-neutron = "${GITTAGREGEX_BETA}"
GITTAGREGEX:pn-python-nova = "${GITTAGREGEX_BETA}"
