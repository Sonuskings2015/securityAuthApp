package com.naggaro.usermanage.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naggaro.usermanage.model.Statement;
import com.naggaro.usermanage.security.StatementService;

@RestController
public class StatementController {

	@Autowired
	StatementService statementService;  
	   
	@GetMapping("/statement/{id}")   
	private Statement getStatement(@PathVariable("id") long id) throws SQLException   
	{  
		return statementService.getStatement(id);   
	}  
	
	@GetMapping("/statement/{id}")
	public List<Statement> getAllStatement() throws SQLException {
		return statementService.getAllStatement();
	}
	
	@DeleteMapping("/statement/{id}")  
	private void deleteStatement(@PathVariable("id") long id)   
	{  
		statementService.deleteStatement(id);
	} 
	
	@PostMapping("/statement/{id}") 
	public HashMap<String, Object> addStatement(@RequestBody Statement statement) throws SerialException, SQLException  {
		return statementService.addStatement(statement);
	}
	
	@PutMapping("/statement/{id}")
	public HashMap<String, Object> updateStatement(@RequestBody Statement statement) throws SerialException, SQLException {  
		return statementService.updateStatement(statement);
	}
}
