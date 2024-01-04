package com.SampleAPI.SampleAPIdemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.SampleAPI.SampleAPIdemo.Model.Student;

public interface StudentInfoRepository extends JpaRepository<Student, Integer> {

	
}
