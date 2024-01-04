# student information REST API using Apache Camel in Spring Boot

This project demonstrates a simple REST API for managing student information using Apache Camel in a Spring Boot application.


#I have create a Maven project for spring boot "SimpleAPIDemo".

#SimpleAPIDemo Project 

## In src/main/java their is package com.SampleAPI.SampleAPidemo

###File structure inside package com.SampleAPI.SampleAPidemo

- [SampleApidemoApplication] (#This is the file were my application is starting my server on http://localhost:8080 )

##Inside the package com.SampleAPI.SampleAPidemo I have create A some more folder

- [com.SampleAPI.SampleAPidemo.controller] -[StudentRoute.java] (#Inside this file create the router for All crud operation    	RestApi Apache Camel )


- [com.SampleAPI.SampleAPidemo.Model] -[Student.java] (#Inside this file I have create student entites)

- [com.SampleAPI.SampleAPidemo.repository] -[StudentInfoReprository.java] (#Inside this Interface we use the Jpa reposirty for 	student information )

- [com.SampleAPI.SampleAPidemo.service] -[StudentService.java] (#Inside this Interface I have create method for student operation that we have to do like createstudent,upadtestudent,getAllstudentdetails,getstudent,deletestudent)

- [com.SampleAPI.SampleAPidemo.service.imple] -[StudentImpl.java] (#Inside this file I have create the method body that I have define in StudentService interface also StudentImpl file we define the logic for are Rest Api crud Oprations)

## In src/test/java their is package com.SampleAPI.SampleAPidemo.service.impl
##Inside  com.SampleAPI.SampleAPidemo.service.impl we write are all testcases for RestFull API
- [ com.SampleAPI.SampleAPidemo.service.impl] -[StudentImplTest.java] (#Inside this class we have write our unit test case for RestFul API)

>we have add the junit5 dependency for unit testing to my Rest Api.
>Also add camel-core,camel-spring-test dependency for camel testing.

#Also do the Database integration to the Restful API
>USE Mysql Database integration With All API Endpoints.
>Use h2 Database integration in Unit Testing for All API Endpoints


#Integrate the Jacoco plugin into My Maven project
>Add the plugin in my maven pom.xml file for generating my reports.
> Generate a detailed code coverage report that reflects the percentage of my codebase covered by unit tests
>Inside [target/jacoco] my index.html file is generate where we see the percentage of all testCase for unit testing.


#API Endpoints
#The API will be available at http://localhost:8080.

##Get All Students-Retrieve a list of all students.
-[GET /api/students]
##Get Student by ID-Retrieve a student by ID.
-[GET /api/students/{id}]
##Add a New Student-Add a New Student
-[POST /api/student
Content-Type: application/json

 { 
     "studentId": 1,
	"studentName": "vishal",
    "studentDateOfBirth":"14-09-2001",
	"studentClass": 12,
	"studentSection": "A",
    "studentTotalMarks": 86
 }]
##Update Student Information-Upadet a student by ID
-[POST /api/student
Content-Type: application/json

 { 
     "studentId": 1,
	"studentName": "updatedname",
    "studentDateOfBirth":"14-09-2001",
	"studentClass": 12,
	"studentSection": "A",
    "studentTotalMarks": 86
 }]
##Delete a Student-Delete a student byID
-[DELETE /api/student/{id}]



