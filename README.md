# README #

### Repository created for the soul purpose of controlling the source code for the **Entersekt Technical Assessment**. ###

### Tasks: ###

1. Write a small little cross platform program in Java 8 that exposes a RESTful interface on port 8080 and allows a client application to do only one thing: obtain the full directory listing of a given directory path on the local filesystem. Include the full path, file size and attribute information in the result and cater for a directory size of at least 1 000 000.  

2.  Refer to https://www.docker.com/what-docker and https://docs.docker.com/engine/reference/builder/. Create a Dockerfile that will allow one to use the “docker build” command on a Linux or Mac OS X machine to create a container distribution of your program. 

### Dev Tools: ###

* JDK 1.8
* Docker Version 17.09.0-ce
* Maven 3


### How to run the application:  ###

Create a .jar and run

	mvn package && java -jar target/gs-rest-service-0.1.0.jar
	
Or
Spring-Boot Plugin:
	
	mvn install
	mvn spring-boot:run

### Create the Docker File ###

Build the dockerfile:

	mvn install dockerfile:build

Image created

	dockertest
	
View docker images
	
	docker images
	
Run docker image

	docker run -p 8080:8080 -t dockertest


### Accessing the service ###

Once the web service is online, visit [http://localhost:8080/PathFinder](http://localhost:8080/PathFinder) to access the content.

The web service contains parameters "directory" and "FileDepth"
* "directory" : Defines the starting directory
* "FileDepth" : Defines how far into the file structure the service will iterate

eg : [http://localhost:8080/PathFinder?directory=C:&FileDepth=10](http://localhost:8080/PathFinder?directory=C:&FileDepth=10)
	
### Unit testing ###

Run the Unit Test:

	mvn test

### TODO: ###

* The Web Service has not been tested on platforms other than windows. Expect bugs/glitches
* Implement a logger. Logging program activity is essential for debugging.
* Improve unit testing. A simple unit test has been implentmented but there is room for improvement.

### Thank you ###

Ranen Naicker - Author
ranen.naicker@gmail.com
