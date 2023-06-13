# springboot-first-app


This project uses Springboot + mysql + docker + postman


Topics and information
Microservice:-
A microservice is a small, independently deployable software component that follows the microservices architectural style. It focuses on a specific business capability and communicates with other microservices through APIs.


Here I am using RESTful microservice.

Quick description about restful service: REST is an architectural style (not a protocol like SOAP, not a technology itself or even not an implementation, it is basically a set of a rule), This architecture offers some constraints for using HTTP. If you stick by this architectural constraints while using HTTP, it is called RESTful, otherwise, it is not-RESTful.


Docker -
Docker is an open-source platform for automating the deployment and management of applications using containers.
Containers provide lightweight and isolated environments for running microservices.
Docker allows for consistent and portable deployments across different environments.
It simplifies the deployment and scaling of microservices.
Docker improves resource efficiency by sharing the host machine's kernel.
It enables versioning and rollbacks for better control and management.
Docker streamlines the development and operations of microservice-based applications.z

Difference between docker and VM:

Docker:
Lightweight, efficient containers
Shares host machine's kernel
Faster startup and shutdown
More scalable and flexible
Less isolation between applications

VM:
Emulates hardware
Runs full operating system
Slower startup and shutdown
Stronger isolation between applications


Steps for installing my project- 

Create database in MYSQL
Useful querie -  Create propertyListing Database. Here run below query.

CREATE TABLE `propertyListing` (
  `listingNumber` int NOT NULL AUTO_INCREMENT,
  `street_address` int DEFAULT NULL,
  `street_name` varchar(250) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `zip` int DEFAULT NULL,
  `cost` int DEFAULT NULL,
  PRIMARY KEY (`listingNumber`),
  UNIQUE KEY `listingNumber_UNIQUE` (`listingNumber`)
) ;


Other helpful mySql quiers - 

SELECT * FROM propertyListing;

UPDATE propertyList
SET street_address = 421, street_name = "Stevenson Blvd"
WHERE listingNumber = 2;

INSERT INTO propertyList (listingNumber, street_address, street_name, city, state, zip)
VALUES (11, 4410, "Smoke Tree Ct", "Concord", "CA", 94521);


Docker commands to set up local:


Create docker network -
Build the coker with your current application path -   
          docker build -t my-spring-app .
Create a netwrok -  
          docker network create my-network
Establish a containor for mySQL - 
          docker run --name mysql-container --network my-network -e MYSQL_ROOT_PASSWORD=12345678 -e MYSQL_DATABASE=propertyListing -d mysql
Establish a containor for microservice - 
          docker run --name spring-app --network my-network -p 8080:8080 -e DB_HOST=mysql-container -e DB_PORT=3306 -e DB_NAME=propertyListing -e DB_USER=root -e DB_PASSWORD=12345678 -d my-spring-app



other docker helpfull commands -
docker ps - tells active docker containers
 docker network ls - gives you list of all networks
docker network inspect my-network - gives you all containers running in this network
