package edu.cjc.smsa.app.servicei;

import java.util.List;

import edu.cjc.smsa.app.model.Student;

public interface StudentServiceI {

	public void saveStudent(Student s);
	public List<Student> getAllStudents();
	public List<Student> searchStudentsByBatch(String batchNumber);

}
