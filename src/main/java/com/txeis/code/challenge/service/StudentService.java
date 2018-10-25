package com.txeis.code.challenge.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.txeis.code.challenge.model.Student;
import com.txeis.code.challenge.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudents() {
		return (List<Student>) studentRepository.getStudents();
	}
	
	public void save(Student studentToBeAdded) {
		if(!studentToBeAdded.getStudentID().equals("")) {
		studentRepository.addStudent(studentToBeAdded.getCampusID(),studentToBeAdded.getStudentID(),studentToBeAdded.getName(),
				studentToBeAdded.getEntryDate(), studentToBeAdded.getGradeLevel(), studentToBeAdded.getSchoolYear());
		}
	}
	
	public Student findStudent(int id) {
		return studentRepository.findStudentById(id);
	}

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public void update(Student studentToBeAdded) {
		studentRepository.updateStudent(studentToBeAdded.getCampusID(),studentToBeAdded.getStudentID(),studentToBeAdded.getName(),
				studentToBeAdded.getEntryDate(), studentToBeAdded.getGradeLevel(), studentToBeAdded.getSchoolYear(), studentToBeAdded.getId() );
		
	}
	
	public void loadStudentList(MultipartFile multiPartFile) {
	    try {
	    	if(multiPartFile.isEmpty()) {
	    		return ;
	    	}
	    	
	        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
	        CsvMapper mapper = new CsvMapper();
	        File file = new File("src/main/csv/students.csv");
	        file.createNewFile();
	        file.setWritable(true);
	        file.setReadable(true);  
	        byte[] bytes=multiPartFile.getBytes();
	        BufferedOutputStream stream= new BufferedOutputStream(new FileOutputStream(file));
	        stream.write(bytes);
	        stream.close();

	        
	        MappingIterator<Student> readValues = mapper.readerFor(Student.class).with(bootstrapSchema).readValues(file);
	        //studentRepository.saveAll(readValues.readAll());
	        saveStudents(readValues.readAll());
	        return;
	    } catch(UnrecognizedPropertyException e) {
	    	e.printStackTrace();
	    	return ;
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return ;
	    }
	}

	private void saveStudents(List<Student> Students) {
		for(Student student: Students) {
			if(studentRepository.findStudentByStuId(student.getStudentID()) == null && !student.getStudentID().equals("")) {
				studentRepository.addStudent(student.getCampusID(), student.getStudentID(), student.getName(), 
						student.getEntryDate(), student.getGradeLevel(), student.getSchoolYear());
			}
			
		}
		
	}

	public List<Student> searchStudents(String schoolYear, String campusID, String studentID,
			String entryDate, String gradeLevel, String name) {
		
	
		if("".equals(schoolYear)){
			schoolYear= "%";
		}else {
			schoolYear = schoolYear.replace("_", "\\_");
		}
		if("".equals(campusID)){
			campusID= "%";
		}else {
			campusID = campusID.replace("_", "\\_");
		}
		if("".equals(studentID)){
			studentID= "%";
		}else {
			studentID = studentID.replace("_", "\\_");
		}
		if("".equals(entryDate)){
			entryDate= "%";
		}else {
			entryDate = entryDate.replace("_", "\\_");
		}
		if("".equals(gradeLevel)){
			gradeLevel= "%";
		}else {
			gradeLevel = gradeLevel.replace("_", "\\_");
		}
		if("".equals(name)){
			name= "%";
		}else {
			name = name.replace("_", "\\_");
		}
		
		return studentRepository.searchStudents(campusID, studentID, name,entryDate , gradeLevel, schoolYear	);
		
	}



}
