# MovieCharactersAPI

## Introduction
The Movie Character Datastore is a Spring Web application designed to store and manipulate data related to movie characters. It utilizes a PostgreSQL database with Hibernate as the Object Relational Mapping (ORM) tool and provides a RESTful API for users to interact with the data.

## Business Rules
The datastore is designed to manage information about characters, movies, and franchises. The following rules govern the relationships between these entities:

One movie contains many characters, and a character can play in multiple movies.
One movie belongs to one franchise, but a franchise can contain many movies.
Data Requirements
The minimum required information to be stored for each entity is as follows:

## Character

Autoincremented Id
Full name
Alias (if applicable)
Gender
Picture (URL to photo – do not store an image)
Movie

Autoincremented Id
Movie title
Genre (just a simple string of comma separated genres, there is no genre modelling required as a base)
Release year
Director (just a string name, no director modelling required as a base)
Picture (URL to a movie poster)
Trailer (YouTube link most likely)
Franchise

Autoincremented Id
Name
Description
Note that nullability and length limitations are up to the implementer's discretion.

## Repositories and Services
The datastore utilizes JPA Repositories to encapsulate data access and Services to encapsulate any business logic.

## Seeding
Some dummy data should be added to the datastore using seeded data. At least three movies, with some characters and franchises, should be added using Spring with data.sql.

## Web API
The following requirements outline the endpoints and functionality of the Web API:

## Generic CRUD

Full CRUD functionality is expected for Movies, Characters, and Franchises.
Proper deletes can be implemented, but related data should not be deleted. Instead, foreign keys can be set to null to account for this.
Adding related data should be deferred to an update.
Representation

Domain models should not be returned. Instead, a representation of the model via DTOs should be returned.
Updating Related Data

There should be dedicated endpoints to update characters in a movie and movies in a franchise.
## Conclusion
The Movie Character Datastore provides a powerful and flexible platform for managing information about movie characters, movies, and franchises. With its intuitive interface and powerful functionality, it is the perfect choice for any organization looking to take control of their digital media data.
