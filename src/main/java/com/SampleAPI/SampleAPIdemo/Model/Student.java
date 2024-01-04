package com.SampleAPI.SampleAPIdemo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_date_of_birth")
	private String studentDateOfBirth;
	@Column(name = "student_class")
	private Integer studentClass;
	@Column(name = "student_section")
	private String studentSection;
	@Column(name = "student_total_marks")
	private Integer studentTotalMarks;

	public Student() {
	}

	public Student(Integer studentId, String studentName, String studentDateOfBirth, Integer studentClass,
			String studentSection, Integer studentTotalMarks) {

		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDateOfBirth = studentDateOfBirth;
		this.studentClass = studentClass;
		this.studentSection = studentSection;
		this.studentTotalMarks = studentTotalMarks;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDateOfBirth() {
		return studentDateOfBirth;
	}

	public void setStudentDateOfBirth(String studentDateOfBirth) {
		this.studentDateOfBirth = studentDateOfBirth;
	}

	public Integer getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentSection() {
		return studentSection;
	}

	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}

	public Integer getStudentTotalMarks() {
		return studentTotalMarks;
	}

	public void setStudentTotalMarks(Integer studentTotalMarks) {
		this.studentTotalMarks = studentTotalMarks;
	}
	
	@Override
	public String toString() {
		return "Student{" + "studentId=" + studentId + ", studentName='" + studentName + '\'' + ", studentDateOfBirth='"
				+ studentDateOfBirth + '\'' + ", studentClass='" + studentClass + '\'' + ", studentSection='"
				+ studentSection + '\'' + ", studentTotalMarks=" + studentTotalMarks + '}';
	}

}
