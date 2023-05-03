package mvc_demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mvc_demo1.dao.StudentDao;
import mvc_demo1.dto.Student;

@Controller
public class Studentcontroller {
	@Autowired
	Student student;
	@Autowired
	StudentDao dao;
	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("student",new Student());
		mav.setViewName("saveStudent.jsp");
		return mav;
	}
	@RequestMapping("/addStudent")
	public ModelAndView addStudent(@ModelAttribute Student student) {
		dao.saveStudent(student);
		ModelAndView mav=new ModelAndView("index.jsp");
		return mav;
	}

	@RequestMapping("/viewStudent")
	public ModelAndView viewStudent() {
		List<Student> student= dao.getAllStudents();
		ModelAndView mav=new ModelAndView("viewStudent.jsp");
		mav.addObject("students", student);
		return mav;
	}
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam int id) {
		ModelAndView mav=new ModelAndView("updateStudent.jsp");
		Student student=dao.getStudent(id);
		mav.addObject("student",student);
		return mav;
	}
	@RequestMapping("/saveUpdateStudent")
	public ModelAndView updateStudent(@ModelAttribute Student student) {
		ModelAndView mav=new ModelAndView("viewStudent.jsp");
		dao.updateStudent(student);
		mav.addObject("students",dao.getAllStudents());
		return mav;
	}
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam int id) {
		ModelAndView mav=new ModelAndView("viewStudent.jsp");
		Student student=dao.getStudent(id);
		dao.deleteStudent(student);
		mav.addObject("students",dao.getAllStudents());
		return mav;
	}
	@RequestMapping("/home")
	public ModelAndView homeStudent() {
		ModelAndView mav=new ModelAndView("index.jsp");
		return mav;
	}
}
