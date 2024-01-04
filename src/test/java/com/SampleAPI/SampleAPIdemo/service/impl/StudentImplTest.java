package com.SampleAPI.SampleAPIdemo.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import com.SampleAPI.SampleAPIdemo.Model.Student;
import com.SampleAPI.SampleAPIdemo.repository.StudentInfoRepository;
import com.SampleAPI.SampleAPIdemo.service.StudentService;


public class StudentImplTest {

	@Mock
	private StudentInfoRepository studentInfoRepository;
	StudentService studentService;
	AutoCloseable autoCloseable;

	Student student;

	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		studentService = new StudentImpl(studentInfoRepository);
		student = new Student(1, "Amazon", "16-08-2003", 12, "A", 74);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	@Order(1)
	void testCreateStudent() {
		mock(Student.class);
		mock(StudentInfoRepository.class);

		when(studentInfoRepository.save(student)).thenReturn(student);
		assertThat(studentService.createStudent(student)).isEqualTo("Success");

	}

	@Test
	@Order(2)
	void testGetAllStudent() {
		mock(Student.class);
		mock(StudentInfoRepository.class);

		when(studentInfoRepository.findAll()).thenReturn(new ArrayList<Student>(Collections.singleton(student)));
		assertThat(studentService.getAllStudentDetails().get(0).getStudentName()).isEqualTo(student.getStudentName());

	}

	@Test
	@Order(3)
	void testGetStudent() {
		mock(Student.class);
		mock(StudentInfoRepository.class);

		when(studentInfoRepository.findById(1)).thenReturn(Optional.ofNullable(student));

		assertThat(studentService.getStudent(1).getStudentId()).isEqualTo(student.getStudentId());
	}

	@Test
	@Order(4)
	void testUpdateStudent() {
		mock(Student.class);
		mock(StudentInfoRepository.class);
		when(studentInfoRepository.save(student)).thenReturn(student);

		assertThat(studentService.updateStudent(student)).isEqualTo("Success");
	}

	@Test
	@Order(5)
	void testDeleteStudent() {
		mock(Student.class);
		mock(StudentInfoRepository.class, Mockito.CALLS_REAL_METHODS);

		doAnswer(Answers.CALLS_REAL_METHODS).when(studentInfoRepository).deleteById(any());

		assertThat(studentService.deleteStudent(1)).isEqualTo("Success");
	}
}
