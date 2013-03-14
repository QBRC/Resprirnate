Resprirnate
============

(RESTEasy + Spring + Hibernate) - A basic Mavenized REST Web Service with Hibernate, Spring, and RESTEasy.

Getting Started
---------------

You should first clone this repository and run `mvn clean install` in the base directory of the repository. This will compile, package, and install all 3 modules after downloading any necessary dependencies.

You'll need to modify the database settings in `server/src/main/resources/properties/database.properties` to match up with your own MySQL server permissions, or create the database and grant the privileges as they already exist in that file. You will then need to create the basic table structure as given in the `database/stock.ddl` file (`mysql -u root -p mkyong < database/stock.ddl` will create an empty `stock` table). If you want to be able to use the server to actually retrieve data, then you'll need to put something in this table. The following would create a couple of elements in this table.

```sql
INSERT INTO stock (STOCK_CODE, STOCK_NAME) VALUES (7668, "HAIO-1"), (1234, "ABCD");
```

You will then need to do some grunt work to deploy the `Server` module to a Servlet Container. You could stick with maven and use a `tomcat:deploy` strategy, try to embed Jetty into the Maven project, or manually deploy to another server (for instance, using Eclipse and a local Tomcat installation).

Once the `Server` module is deployed and running, you should be able to run the Client.

```
cd client
mvn exec:java
```

If you added the above data to the database and everything's setup properly, you should see a "BUILD SUCCESS" message. Now you can fork and modify as you please!

Modules
-------

###Shared

This module includes packages which should be shared between the server and the client. It includes all Domain objects as well as the annotated interfaces describing how the RESTEasy web services should function. This is a very simple package which just wraps up the shared classes as a `jar` file.

###Server

This module depends on the `Shared` module and implements the server-side code necessary for the web-service. It uses Spring for DI and Hibernate for ORM. It implements the interface(s) described in the `Shared` module to serve thsoe REST services. It will be packaged as a `war` file and must be deployed to some Servlet container (Tomcat, Jetty, etc.).

###Client

This module offers no new functionality and likely would be excluded from any forks of this project deployed in production, but merely provides an example of how to use the web service "remotely" from a Spring-enabled Java client. Note that the default deployment URL in `applicationContext.xml` expects the web service to be available at `http://127.0.0.1:8080/resprirnate-server/rest` which may not be the default for your IDE/Servlet container.

Authentication
--------------

If you wish to authenticate users to your Resprirnate-based service, be sure to check out CasHmac at https://github.com/QBRC/CasHmac/.  CasHmac is a library that provides both client and server support for CAS and HMAC authentication for RESTEasy RESTful Web services.

