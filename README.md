# JSFSample

To start project run 'mvn clean package' and deploy on AS (recommended WildFly 17).

## Branch withDatabase:

To use this branch, you need to:
- Install and run (or access) a PostgreSQL database server

As I used this, I also recommend you to use version 9.6. To manage your DB, it is worthy to install e.g. pgAdmin.

During installation, please change listening port to 65432 (from the default 5432).

If you are done, you should create a database, called **HelloPostgre**.

In this database you will have to create a table:
```sql
CREATE TABLE WORLD(
   ID 		BIGSERIAL 	PRIMARY KEY     NOT NULL,
   UNIVERSE     TEXT,
   HELLOED	BOOLEAN
);
```
- Configure your Wildfly with your datasource

In AS' standalone.xml, in section
```xml
<subsystem xmlns="urn:jboss:domain:datasources:5.0">
  <datasources>
    ...
```
please add
```xml
<datasource jta="true" jndi-name="java:jboss/datasources/HelloWorldDS" pool-name="HelloWorldDS" use-java-context="true">
  <connection-url>jdbc:postgresql://localhost:65432/HelloPostgre</connection-url>
  <driver-class>org.postgresql.Driver</driver-class>
  <driver>postgresql-42.2.8.jar</driver>
  <security>
    <user-name>postgres</user-name>
    <password>YOURPASSWORD</password>
  </security>
  <validation>
    <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker"/>
    <background-validation>true</background-validation>
    <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter"/>
  </validation>
</datasource>
```
- Deploy PostgreSQL driver on AS

Download the JAR from [central repository](https://repo1.maven.org/maven2/org/postgresql/postgresql/42.2.8/)

Open Deployments in WildFly Management Console (likely [localhost:9990](http://localhost:9990/console/index.html#deployments)) and upload the downloaded JAR.

If you first use this Management Console, you will have to create a user, by using **$JBOSS_HOME\bin\add_user.bat** (on Windows). You can read more about this on [Official JBOSS site](https://docs.jboss.org/author/display/WFLY10/Default+HTTP+Interface+Security)
