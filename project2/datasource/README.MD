1. Install postgresql driver
    1. As it is no bundle we use the wrap protocol to create a suitable Manifest on the fly:
       > install -s wrap:mvn:postgresql/postgresql/9.1-901.jdbc4
    1. PostgreSQL JDBC Driver OSGi Bundle 
       ><dependency>
            <groupId>org.ancoron.postgresql</groupId>
            <artifactId>org.postgresql</artifactId>
            <version>9.1.901.jdbc4.1-rc9</version>
        </dependency>
        
       > install -s mvn:org.ancoron.postgresql/org.postgresql/9.1.901.jdbc4.1-rc9
1. [about configuration  postgresql Datasource](https://jdbc.postgresql.org/documentation/head/ds-ds.html)


        
        