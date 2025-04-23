package edu.cjc.smsa.app.servicei;

import java.util.List;

import edu.cjc.smsa.app.model.Student;

public interface StudentServiceI {

	public void saveStudent(Student s);
	public List<Student> getAllStudents();
	public List<Student> searchStudentsByBatch(String batchNumber);
	public Student getSingleObject(int rollno);
	public void updateStudentFees(int rollno, double ammount);
	public void deleteStudent(int rollno);

}
