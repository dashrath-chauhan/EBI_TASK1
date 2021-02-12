## EBI Assessment Task1
## Person REST API Example

This application is developed using Java and Spring Boot.

## Documentaion:
	Please refer to file: EMBL_EBI_Project_Documentation.pdf

## Deployement steps:
	1. Open Git bash.
	
	2. Clone repository:
		git clone git@github.com:dashrath1526/EBI_TASK1.git

	3. goto the repository location in local directory and change the branch to master.
		git checkout master
	
	4. Clean and install maven dependencies.
		mvn clean install

	5. Run application as spring boot application.
		mvn spring-boot:run

# REST API

The REST API to the example app is described below.
Tested in postman tool.

## Get list of Persons

### Request

`GET /api/v1/persons` 
`Basic Auth username:test, password:test`

    http://localhost:8080/api/v1/persons

### Response

    HTTP/1.1 200 OK
    Date: Fri, 12 Feb 2021 06:41:56 GMT
    Status: 200 OK
    Content-Type: application/json

    [
		{
			"id": 1,
			"first_name": "John",
			"last_name": "Doe",
			"age": 25,
			"favourite_colour": "Red"
		},
		{
			"id": 2,
			"first_name": "Black",
			"last_name": "Smith",
			"age": 30,
			"favourite_colour": "Green"
		}
	]

## Create new persons

### Request

`POST /api/v1/persons`
`Basic Auth username:admin, password:admin`

    http://localhost:8080/api/v1/persons 
	Request Body
	[
		{
			 "first_name": "John",
			 "last_name": "Keynes",
			 "age": "29",
			 "favourite_colour": "red"
		},
		{
			"first_name": "Sarah",
			"last_name": "Robinson",
			"age": "54",
			"favourite_colour": "blue"
		}
	]

### Response

    HTTP/1.1 201 Created
    Date: Fri, 12 Feb 2021 06:47:29 GMT
    Status: 201 Created
    Content-Type: application/json

    [
		{
			"id": 3,
			"first_name": "John",
			"last_name": "Keynes",
			"age": 29,
			"favourite_colour": "red"
		},
		{
			"id": 4,
			"first_name": "Sarah",
			"last_name": "Robinson",
			"age": 54,
			"favourite_colour": "blue"
		}
	]

## Get a specific Thing

### Request

`GET /api/v1/person/{personId}`

    http://localhost:8080/api/v1/person/1

### Response

    HTTP/1.1 200 OK
    Date: Fri, 12 Feb 2021 06:49:43 GMT
    Status: 200 OK
    Content-Type: application/json

    {
		"id": 1,
		"first_name": "John",
		"last_name": "Doe",
		"age": 25,
		"favourite_colour": "Red"
	}

## Get a non-existent Thing

### Request

`GET /api/v1/person/{personId}`

    http://localhost:8080/api/v1/person/5

### Response

    HTTP/1.1 404 Not Found
    Date: Fri, 12 Feb 2021 06:50:45 GMT
    Status: 404 Not Found
    Content-Type: application/json

    {
		"timestamp": 1613112645835,
		"status": 404,
		"error": "Not Found",
		"exception": "org.user.ResourceNotFoundException",
		"message": "No person found for Id: 5",
		"path": "/api/v1/person/5"
	}

## Modify person entites

### Request

`PUT /api/v1/persons` 
`Basic Auth username:test, password:test`

    http://localhost:8080/api/v1/persons
	Request Body
	[
		{
			"id":2,
			"first_name": "Sarah",
			"last_name": "Robinson",
			"age": 20,
			"favourite_colour": "pink"
		},
			{
			"id": 4,
			"first_name": "Sarah",
			"last_name": "Robinson",
			"age": 70,
			"favourite_colour": "blue"
		}
	]

### Response

    HTTP/1.1 200 OK
    Date: Fri, 12 Feb 2021 07:02:49 GMT
    Status: 200 OK
    Content-Type: application/json

    [
		{
			"id": 2,
			"first_name": "Sarah",
			"last_name": "Robinson",
			"age": 20,
			"favourite_colour": "pink"
		},
		{
			"id": 4,
			"first_name": "Sarah",
			"last_name": "Robinson",
			"age": 70,
			"favourite_colour": "blue"
		}
	]

## Get changed person

### Request

`GET /api/v1/person/{personId}`

    http://localhost:8080/api/v1/person/2

### Response

    HTTP/1.1 200 OK
    Date: Fri, 12 Feb 2021 07:05:37 GMT
    Status: 200 OK
    Content-Type: application/json

    {
		"id": 2,
		"first_name": "Sarah",
		"last_name": "Robinson",
		"age": 20,
		"favourite_colour": "pink"
	}

## Delete a Person entity

### Request

`DELETE /api/v1/person/{personId}`

    http://localhost:8080/api/v1/person/2

### Response

    HTTP/1.1 200 OK
    Date: Fri, 12 Feb 2021 07:07:33 GMT
    Status: 200 OK

	Person deleted with id: 2
	
## Try to delete same Person again

### Request

`DELETE /api/v1/person/{personId}`

    http://localhost:8080/api/v1/person/2

### Response

    HTTP/1.1 404 Not Found
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 404 Not Found
    Content-Type: application/json

    {
		"timestamp": 1613113714566,
		"status": 404,
		"error": "Not Found",
		"exception": "org.user.ResourceNotFoundException",
		"message": "No person found for Id: 2",
		"path": "/api/v1/person/2"
	}

## Get deleted Person

### Request

`GET /api/v1/person/{personId}`

    http://localhost:8080/api/v1/person/2

### Response

    HTTP/1.1 404 Not Found"
    Date: Fri, 12 Feb 2021 07:09:41 GMT
    Status: 404 Not Found"
    Content-Type: application/json

    {
		"timestamp": 1613113781538,
		"status": 404,
		"error": "Not Found",
		"exception": "org.user.ResourceNotFoundException",
		"message": "No person found for Id: 2",
		"path": "/api/v1/person/2"
	}