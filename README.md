<h1 align="center">
  Order System 
</h1>

#Technical task
## Problem Overview ####

A Manufacturing company has various warehouses in multiple cities. When an order for a product is placed by their
customers, the company wants to make sure the order is picked up from the warehouse that is closest to the customers
location and containing the product.

**Ask**

Build a microservice with a REST API based interface to solve the above problem. There should be at least two key APIs
one for adding of a new customer and the other to place of an order. The order placement API in the response should
indicate from which warehouse the product would be delivered and the time/distance for arrival. The expectation is that
the response time of order placement is fairly quick (< 500ms).

**Assumptions**

Assume that the distance/time between the customers city/location and warehouse is provided when customer is setup. The
system would compute the using the data that is provided during setup. The format of the data can be anything as per the
solution.

Assume a certain number of Warehouses & products to be present. Assume any structure for the data. Preferably represent
that in JSON format as static data (or stored in db) that can be used for computation.

**Technology requirements**

- Build the solution using Java
- Preferably build the service using Sprint Boot
- Usage of database is not necessary
- Submit a brief write up of any key decisions being made
- Bonus points for writing unit test cases (key scenarios)

# System logic

Only a registered customer can place an order.
When registering each customer in the system, we calculate the distance from the customer to all warehouses. This allows, when a customer orders a product, to do all the filtering at the database level and find the nearest warehouse with the desired product.

The system also has form validation for creating a customer, which displays error messages in detail.

## API ##

You can find API definition by follows link:

- http://localhost:8080/swagger-ui/index.html

API endpoints:

- http://localhost:8080/api/product (HTTP:GET) - find all products
- http://localhost:8080/api/order (HTTP:GET) - find all orders
- http://localhost:8080/api/warehouse (HTTP:GET) - find all warehouses
- http://localhost:8080/api/customer (HTTP:POST) - create Customer
- http://localhost:8080/api/order (HTTP:POST) - create Order

##Technology stack
- Rest API
- Spring Boot (Data, Web)
- Spring Doc
- JUnit 5, Mockito
- H2 Database
- Lombok
- Lucene Spatial

###Rationale for the choice

**Spring Doc** - for API documentation

**Lombok** - make your code cleaner, save your time

**H2 DB** -  it is ideal for fast prototyping database.And it didn't require any additional read/write logic as it would be with JSON file.

**Lucene Spatial** - library to calculate distance between two locations.

The choice of other technologies is based on the fact that they are easy to set up and integrate, such project could be easily packed as docker image and deployed anywhere.


## Example of validation ##

Create customer cURL:

```sh
curl --location --request POST 'http://localhost:8080/api/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
"firstName": "",
"lastName": "",
"latitude": 155.54,
"longitude": 836.54
}'
```

```sh
	
Error: response status is 400
Response body
{
  "message": "Invalid data, please correct errors and try again.",
  "errors": [
    "Field first name must not be empty",
    "First name must be between one and 24 characters",
    "Latitude must be lower or equal 90",
    "Last name must be between one and 24 characters",
    "Field last name must not be empty",
    "Longitude must be lower or equal 180"
  ]
}'
```