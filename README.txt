Pre-requirements:
Java 8
Tomcat 7 and upper 
PostgreSql 9.0
maven 4
Intellij Idea 2016



Configuration:
1 Download and unzip project
2 In postgres database in your default schema(if you did't change default schema, it must be "public") create table and insert values use SQL script
2 Create in PostgreSql your database, use Sql script file.
3 Specify in file src/main/resources/hibernate.properties parameters of connection to your database
- url
- username
- password
4 Build project
5 Copy .war to Tomcat
6 Launch application using browser link: localhost:8080/welcome


