# POC

## Start Spring

![Spring](start-spring-io.png)

## Postgres

```
spring.datasource.url=jdbc:postgresql://localhost:5432/poc
spring.datasource.username=postgres
spring.datasource.password=

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto = update
```