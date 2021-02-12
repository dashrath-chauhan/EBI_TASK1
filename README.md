# EBI_TASK1
Person Rest App

Documentaion:
	Please refer to file:  

Deployement steps:
1. Open Git bash.

2. Clone repository:
	git clone git@github.com:dashrath1526/EBI_TASK1.git

3. goto the repository location in local directory and change the branch to master.
	git checkout master
	
4. Clean and install maven dependencies.
	mvn clean install

5. Run application as spring boot application.
	mvn spring-boot:run
	
	
API testing
POST http://localhost:8080/api/v1/persons
Request Body:
	[
		{
			 "first_name": "John",
			 "last_name": "Keynes",
			 "age": 29,
			 "favourite_colour": "red"
		},
		{
			"first_name": "Sarah",
			"last_name": "Robinson",
			"age": 54,
			"favourite_colour": "blue"
		}
	]
Response:
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

GET http://localhost:8080/api/v1/persons

GET	http://localhost:8080/api/v1/person/5
Response:
	{
		"timestamp": 1612978311722,
		"status": 500,
		"error": "Internal Server Error",
		"exception": "org.user.exception.ResourceNotFoundException",
		"message": "No person found for Id: 5",
		"path": "/api/v1/person/5"
	}

GET	http://localhost:8080/api/v1/person/3
Response:
	{
		"id": 3,
		"first_name": "John",
		"last_name": "Keynes",
		"age": 29,
		"favourite_colour": "red"
	}

PUT http://localhost:8080/api/v1/persons
Request Body:
	[
		{	
			"id":3,
			 "first_name": "John",
			 "last_name": "Keynes",
			 "age": 30,
			 "favourite_colour": "red"
		},
		{
			"id":4,
			"first_name": "Sarah",
			"last_name": "Robinson",
			"age": 30,
			"favourite_colour": "blue"
		}
	]

Response:
	[
		{
			"id": 3,
			"first_name": "John",
			"last_name": "Keynes",
			"age": 30,
			"favourite_colour": "red"
		},
		{
			"id": 4,
			"first_name": "Sarah",
			"last_name": "Robinson",
			"age": 30,
			"favourite_colour": "blue"
		}
	]
	
DELETE http://localhost:8080/api/v1/person/5
Response:
	{
		"timestamp": 1612978435148,
		"status": 500,
		"error": "Internal Server Error",
		"exception": "org.user.exception.ResourceNotFoundException",
		"message": "No person found for Id: 5",
		"path": "/api/v1/person/5"
	}

DELETE http://localhost:8080/api/v1/person/1
Response:
	Person deleted with id: 1
