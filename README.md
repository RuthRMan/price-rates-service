# price-rates-service
Example of a REST service which consult price rates of products from different branches.

## Functionality
The implementation of this REST service includes the following endpoints:
- /product/pricerate: GET endpoint which consult price rates of a product, depending on date and branch.

## Technologies
It has been implemented in Java 17 with Spring Boot Framework under a hexagonal architecture. Accesses to the database, which is an H2 in-memory database type, are done with JPA.

## Test manual
There is a Postman Collection with a GET request to test the service (/test/resources).
In addition, there are tests implemented to perform code coverage and run different cases with the data inserted in the database.