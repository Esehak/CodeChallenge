package com.txeis.code.challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.springframework.lang.NonNull;

@NamedNativeQueries({
    		@NamedNativeQuery(name="Student.addStudent", query="insert into Student (campusID,studentID,name,entry_date,grade_level,school_year) values (:campusID,:studentID,:name,:entry_date,:grade_level,:schoolYear)",
    		 resultClass=Student.class),
            @NamedNativeQuery(
    		name="Student.updateStudent", query="update Student set campusID= ?, studentID= ?, name= ?,entry_date= ?,grade_level= ?,school_Year= ? where id=?",
   		    resultClass=Student.class
            ),
            @NamedNativeQuery(
            name="Student.searchStudents", query="select * from Student where campusID like ? and studentID like ? and name like ? and entry_date like ? and grade_level like ? and school_Year like ? ",  resultClass=Student.class
            )
})

@Entity(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NonNull
	@Column(name="school_year",columnDefinition="CHAR(4)")
	private String schoolYear;
	@Column(name="campusID",columnDefinition="CHAR(3)")
	private String campusID;
	@Column(name="studentID",columnDefinition="CHAR(6)")
	private String studentID;
	@Column(name="entry_date",columnDefinition="CHAR(10)")
	private String entryDate;
	@Column(name="grade_level",columnDefinition="CHAR(2)")
	private String gradeLevel;
	@Column(name="name",columnDefinition="VARCHAR(40)")
	private String name;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getCampusID() {
		return campusID;
	}

	public void setCampusID(String campusID) {
		this.campusID = campusID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
