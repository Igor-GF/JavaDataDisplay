# JAVA DATA ACCES RPG
This project is created as part of the Java Fullstack - Experis Remote course. This application is build to read a Chinook SQL Lite database through JDBC. It also shows a thymeleaf view. Futhermore, it is published as a Docker container on Heroku.

## Getting Started
This project can be cloned using: git clone https://github.com/Igor-GF/JavaDataDisplay

### Prerequisites
None

## Running the tests
The REST endpoints are in the following:
https://localhost:8080/api/bar/customers
https://localhost:8080/api/bar/id/query
https://localhost:8080/api/bar/name/query
https://localhost:8080/api/bar/between
https://localhost:8080/api/bar/customers/byCountry
https://localhost:8080/api/bar/invoice/highestSpenders
https://localhost:8080/api/bar/customers

The add-customer and the update-customer do not work as of now. They need to be checked in postman since that gives a required body error. The last one also does not work. The Thymeleaf end-points are:
https://localhost:8080/api/home
https://localhost:8080/api/home/search

## Built With
IntelliJ IDEA

## Authors
Igor Figueiredo and Dianto Bosman

## Acknowledgments
We received help from Iljaas Dohnre: https://github.com/iljaasdhonre and Craig Marais: https://gitlab.com/muskatel. We also discussed a few methods with Kasper G. Andreasen.
