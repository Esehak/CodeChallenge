package com.txeis.code.challenge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.txeis.code.challenge.model.Student;
import com.txeis.code.challenge.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getHome(ModelAndView mnv) {
		mnv.setViewName("home");
		return mnv;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getStudent(@ModelAttribute("students") Student student, ModelAndView mnv) {
		mnv.setViewName("students");
		mnv.addObject("students", studentService.getStudents());
		return mnv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addStudent(@ModelAttribute("newStudent") Student student, ModelAndView mnv) {
		mnv.setViewName("addStudent");
		return mnv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewStudent(@Valid @ModelAttribute("newStudent") Student studentToBeAdded,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addStudent";

		}
		try {
			
				studentService.save(studentToBeAdded);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Transaction FAILED");

		}

		return "redirect:/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updateStudent(@Valid @ModelAttribute("newStudent") Student studentToBeAdded,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addStudent";

		}
		try {
			
				studentService.update(studentToBeAdded);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Transaction FAILED");

		}

		return "redirect:/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editStudent(@PathVariable int id, @ModelAttribute("newStudent") Student student,
			ModelAndView mnv) {
		mnv.addObject("newStudent", studentService.findStudent(id));
		mnv.setViewName("addStudent");
		return mnv;
	}

	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public ModelAndView importStudents(ModelAndView mnv) {
		mnv.setViewName("importStudents");
		return mnv;
	}
	

	@RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importStudents(@RequestParam("file") MultipartFile file) {

        studentService.loadStudentList(file);

        return "importStudents";
    }

   

	@RequestMapping(value = "/list/search", method = RequestMethod.POST  )
	@ResponseBody
    public List<Student> search(@RequestParam String schoolYear, @RequestParam String campusID, @RequestParam String studentID,
    		@RequestParam String entryDate, @RequestParam String gradeLevel, @RequestParam String name) {

		List<Student> students = studentService.searchStudents(schoolYear,campusID,studentID,entryDate,gradeLevel,name);
		return students;
    }
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
