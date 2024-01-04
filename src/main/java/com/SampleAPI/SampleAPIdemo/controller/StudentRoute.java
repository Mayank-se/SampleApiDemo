package com.SampleAPI.SampleAPIdemo.controller;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.SampleAPI.SampleAPIdemo.Model.Student;
import com.SampleAPI.SampleAPIdemo.service.StudentService;
import com.SampleAPI.SampleAPIdemo.service.impl.StudentImpl;

@Component
public class StudentRoute extends RouteBuilder {

	StudentService studentService;
	
	

	public StudentRoute(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	public void configure() throws Exception {
//		#Use Get Request to get All the student Info from the Records
		rest("/api").get("/student").produces(MediaType.APPLICATION_JSON_VALUE).outType(String.class)
				.to("direct:getAllStudents");

		from("direct:getAllStudents").setBody().method(StudentImpl.class, "getAllStudentDetails").marshal().json();

//		#Use Post Request to create A new Student in the Records
		rest("/api").post("/student").produces(MediaType.APPLICATION_JSON_VALUE).outType(String.class)
				.to("direct:createStudent");

		from("direct:createStudent").unmarshal().json(Student.class).bean(studentService, "createStudent")
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201)).setBody()
				.constant("Student created successfully");

//		#Use Delete Request to delete A Particular student data from the Records  
		rest("/api").delete("/student/{id}").produces(MediaType.APPLICATION_JSON_VALUE).outType(String.class)
				.to("direct:deleteStudent");

		from("direct:deleteStudent").setHeader("studentId").simple("${header.id}")
				.bean(StudentImpl.class, "deleteStudent(${header.id})").choice().when(body().isNotEqualTo(null))
				.setBody().constant("Student deleted successfully").log("deleteStudent method executed successfully")
				.otherwise().setHeader(Exchange.HTTP_RESPONSE_CODE, constant(404)).setBody()
				.constant("Student not found");

//		#Use Get Request to get A Particular Student data from the Records
		rest("/api").get("student/{id}").produces(MediaType.APPLICATION_JSON_VALUE).outType(Student.class)
				.to("direct:getStudent");

		from("direct:getStudent").log("Processing getStudent route").setHeader("studentId").simple("${header.id}")
				.log("StudentId header set to: ${header.studentId}").setBody()
				.method(StudentImpl.class, "getStudent(${header.studentId})").log("StudentId body set to: ${body}")
				.choice().when(body().isNotEqualTo(null)).marshal().json()
				.log("getStudent method executed successfully").otherwise()
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(404)).setBody().constant("Student not found");

//     #Use Update Request to updating an existing student by ID
		rest("/api").put("student/{id}").produces(MediaType.APPLICATION_JSON_VALUE).outType(Student.class)
				.to("direct:updateStudent");

		from("direct:updateStudent").unmarshal().json(Student.class).setHeader("studentId").simple("${header.id}")
				.log("StudentId header set to: ${header.studentId}").bean(StudentImpl.class, "updateStudent").choice()
				.when().simple("${body} != null").setBody().constant("Student updated successfully")
				.log("updateStudent method executed successfully").otherwise()
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(404)).setBody().constant("Student not found");

	}

}
