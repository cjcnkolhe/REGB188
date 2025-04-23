package edu.cjc.smsa.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.smsa.app.model.Student;
import edu.cjc.smsa.app.servicei.StudentServiceI;

@Controller
public class AdminController {

	@Autowired
	StudentServiceI ssi;
	@GetMapping("/")
	public String preLogin() {
		return "login";
	}

	@GetMapping("/login")
	public String loginStudent(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
		  
		       if(username.equals("ADMIN") && password.equals("ADMIN"))
		       {
		    	   List<Student> list=ssi.getAllStudents();
		    	   m.addAttribute("data",list);
		    	   return "adminscreen";
		       }else {
		    	   return "login";
		       }
		
	}
	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s,Model m) {
		      ssi.saveStudent(s);  
		      List<Student> list=ssi.getAllStudents();
	    	   m.addAttribute("data",list);
		return "adminscreen";
	}
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam("batchNumber") String batchNumber,Model m) {
		List<Student> results=ssi.searchStudentsByBatch(batchNumber);
		      if(results.size()>0) {
		    		m.addAttribute("data", results);
		      }else {
		    	  List<Student> list=ssi.getAllStudents();
		    	   m.addAttribute("data",list);
		    	   m.addAttribute("message","No Reacord Available for this Batch Number "+batchNumber);
		      }

	
		return "adminscreen";
	}
	
	@RequestMapping("/Fees")
	public String onFees(@RequestParam("rollno") int rollno,Model m)
	{
		     Student s      =ssi.getSingleObject(rollno);
		     m.addAttribute("st", s);
		     return "fees";
	}
	@RequestMapping("/payfees")
	public String  payFees(@RequestParam("rollno") int rollno,@RequestParam("ammount") double ammount,Model m) {
		
		  ssi.updateStudentFees(rollno,ammount);
		  List<Student> list=ssi.getAllStudents();
		  m.addAttribute("data", list);
		  return "adminscreen";
	}
	@RequestMapping("/remove")
	public String removeStudent(@RequestParam("rollno") int rollno,Model m)
	{
		        ssi.deleteStudent(rollno);
		        List<Student> list=ssi.getAllStudents();
				  m.addAttribute("data", list);
		     return "adminscreen";
	}
}
