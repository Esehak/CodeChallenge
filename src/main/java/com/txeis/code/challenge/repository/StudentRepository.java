package com.txeis.code.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.txeis.code.challenge.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query(value = "SELECT * FROM STUDENT" , nativeQuery= true)
	public List<Student> getStudents();
    
	@Modifying
	@Transactional
	@Query(nativeQuery = true)
	public void addStudent(@Param("campusID") String campusID, @Param("studentID") String studentID, 
			@Param("name") String name, @Param("entry_date") String entryDate, @Param("grade_level") String gradeLevel,
			@Param("schoolYear") String schoolYear);

	@Modifying
	@Transactional
	@Query(nativeQuery = true)
	public void updateStudent(@Param("campusID") String campusID, @Param("studentID") String studentID, 
			@Param("name") String name, @Param("entry_date") String entryDate, @Param("grade_level") String gradeLevel,
			@Param("schoolYear") String schoolYear, @Param("id") int id);

	@Query(value="select * from student s where s.id= :id" , nativeQuery= true)
	public Student findStudentById(@Param("id") int id);

	@Query(value="select * from student s where s.studentid= :studentID" , nativeQuery= true)
	public Student findStudentByStuId(@Param("studentID") String stuId);

	@Query(nativeQuery = true)
	public List<Student> searchStudents(@Param("campusID") String campusID, @Param("studentID") String studentID, 
			@Param("name") String name, @Param("entry_date") String entryDate, @Param("grade_level") String gradeLevel,
			@Param("schoolYear") String schoolYear);
	
}
