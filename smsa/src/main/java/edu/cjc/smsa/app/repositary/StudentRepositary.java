package edu.cjc.smsa.app.repositary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.smsa.app.model.Student;
@Repository
public interface StudentRepositary  extends CrudRepository<Student,Integer>{

	
	public List<Student> findAllByBatchNumber(String batchNumber);
}
