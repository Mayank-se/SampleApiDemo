package com.SampleAPI.SampleAPIdemo.service;

import java.util.List;

import com.SampleAPI.SampleAPIdemo.Model.Student;

public interface StudentService {
	public String createStudent(Student studentModel);

	public String updateStudent(Student studentModel);

	public String deleteStudent(Integer studentId);

	public Student getStudent(Integer studentId);

	public List<Student>  getAllStudentDetails();
}
