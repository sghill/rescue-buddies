Rescue Buddies
==============

A small webservice centered on fostering rescue dogs (buddies!).

Rescue Buddies is structured in a way that allows for great code reuse. It also
features a full build that verifies the entire application in under a minute:

* compilation
* unit tests
* uberjar packaging
* acceptance tests with robotframework
** packaged app deployed
** in-memory database created
** migrations applied to in-memory database

Build
-----
Just a standard maven build: `mvn -T1C clean install`

Domain Model
------------
![Rescue Buddies Domain Model](http://www.gliffy.com/go/publish/image/7111057/L.png)

License
-------
Apache 2.0
