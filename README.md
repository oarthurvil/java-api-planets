# Java REST API Planets

REST API that contains the data of the planets.

## Table of contents

- [Overview](#overview)
  - [The challenge](#the-challenge)
- [My process](#my-process)
  - [Built with](#built-with)
- [The project](#the-project)
  - [Database](#database)
  - [Create](#Create)
  - [Read](#Read)
  - [Update](#Update)
  - [Delete](#Delete)


- [Challenge reference](#challenge-reference)


## Overview

### The challenge

- REST API model.
- For each planet, the following data must be obtained from the application database and manually entered:
  - Nome (name)
  - Clima (climate)
  - Terreno (terrain)

Desired features:

- Create a planet
- Read planets:
  - All planets
  - By id 
  - By name
- Update planets
- Delete planets

## My process

### Built with

* VSCode IDE
* Java 17
* Java POO
* Maven
* Spring Boot
* MySQL

## The project

### Database
In "application.properties" (path: src/main/resources/application.properties) make the necessary settings for the database:

~~~
spring.datasource.url=jdbc:mysql://localhost:3306/starwars_planetas?createDatabaseIfNotExist=True
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
~~~

### Create

- Path: /planetas/criar
- Method: POST
- Body of the request: JSON
~~~
{
	"nome": "Planet X",
	"clima": "Rainy",
	"terreno": "Swampy"
}
~~~


### Read

- All planets:
  - Path: /planetas
  - Method: GET
  
- Planets by ID:
  - Path: /planetas/id={planet id}
  - Path example: /planetas/id=1
  - Method: GET
  
- Planets by name:
  - Path: /planetas/nome={planet_name_with_underscore}
  - Path example: /planetas/nome=planet_x
  - Method: GET
  - **exchange empty spaces for underscore**


### Update

- Path: /planetas/editar/id={planet id}
- Path example: /planetas/editar/id=1
- Method: PUT
- Body of the request: JSON
~~~
{
	"nome": "Planet X edit",
	"clima": "Rainy",
	"terreno": "Swampy"
}
~~~


### Delete

- Path: /planetas/deletar/id={planet id}
- Path example: /planetas/deletar/id=1
- Method: DELETE
   
## Challenge reference
[Source of the challenge.](https://github.com/AmeDigital/challenge-back-end-hit)
