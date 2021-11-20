# SCS3203-Middleware Architecture - Assignment 2

## 1. How to build and/or deploy the API

### step 1
 This is an instruction to build & run the Dockerfile of this project.

 Before building the docker image run:
  <br><b> mvn package</b>
  
 Then, build the docker image with:
 <br><b> docker build -f src/main/docker/Dockerfile.jvm -t quarkus-demo </b>
  
 Then run the container using:
  <br><b>docker run -i --rm -p 8080:8080 quarkus-demo</b>
  

### step 2
Mysql is used as the database for this project.

There is an sql dump file to the repository.

-First install XAMPP to your machine
-Go to phpmyadmin server
-create a database called "pet_store_db"
-import the sql file given in the repository
then you ready to run the application. 


## 2. How to run test suite
Tests are written using JUnit.
Firstly run the project.
Select a test case and then run using intelliJ or any other IDE.


## 3. How to run a CURL/WGET command to test the APIs once deployed

This is the instruction to test the APIs using command line.

Open the command line.
* get the pet details.
curl http://localhost:8080/pet/getDetails
