package com.SampleAPI.SampleAPIdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SampleAPI.SampleAPIdemo.Model.Student;
import com.SampleAPI.SampleAPIdemo.repository.StudentInfoRepository;
import com.SampleAPI.SampleAPIdemo.service.StudentService;

@Service
public class StudentImpl implements StudentService {

	StudentInfoRepository studentInfoRepository;
	 private static List<Student> students = new ArrayList<>();

	public StudentImpl(StudentInfoRepository studentInfoRepository) {
		this.studentInfoRepository = studentInfoRepository;
	}

	@Override
	public String createStudent(Student studentModel) {
	     students.add(studentModel);
		studentInfoRepository.save(studentModel);
		return "Success";
	}

	@Override
	public String updateStudent(Student studentModel) {
		  for (int i = 0; i < students.size(); i++) {
	            Student student = students.get(i);
	            if (student.getStudentId() == studentModel.getStudentId()) {
	                students.set(i, studentModel);
	                studentInfoRepository.save(studentModel);
	                return "Success";
	            }
		  }
		return null;
	}

	@Override
	public String deleteStudent(Integer studentId) {
		 
		if (students.removeIf(student -> student.getStudentId() == studentId)) {
			studentInfoRepository.deleteById(studentId);
			return "Success";
		}
		return null;
	}

	@Override
	public Student getStudent(Integer studentId) {

		  for (Student student : students) {
	            if (student.getStudentId() == studentId) {
	            	return studentInfoRepository.findById(studentId).get();
	            }
		  }
		return null;
	}

	@Override
	public List<Student>  getAllStudentDetails() {
		return studentInfoRepository.findAll();
	}

}
