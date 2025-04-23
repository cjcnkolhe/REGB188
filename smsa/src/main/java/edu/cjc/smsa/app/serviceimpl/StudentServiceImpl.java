package edu.cjc.smsa.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.smsa.app.model.Student;
import edu.cjc.smsa.app.repositary.StudentRepositary;
import edu.cjc.smsa.app.servicei.StudentServiceI;
@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	StudentRepositary sr;
	
	@Override
	public void saveStudent(Student s) {
	
		sr.save(s);
	}

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) sr.findAll();
	}

	@Override
	public List<Student> searchStudentsByBatch(String batchNumber) {
		return sr.findAllByBatchNumber(batchNumber);
	}

	@Override
	public Student getSingleObject(int rollno) {
		return sr.findById(rollno).get();
	}

	@Override
	public void updateStudentFees(int rollno, double ammount) {
		 Student   s  = sr.findById(rollno).get();
		 s.setFeesPaid(s.getFeesPaid()+ammount);
             sr.save(s);		             
	}

	@Override
	public void deleteStudent(int rollno) {
                 sr.deleteById(rollno);		
	}

}
