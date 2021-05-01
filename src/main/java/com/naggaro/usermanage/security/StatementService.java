package com.naggaro.usermanage.security;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naggaro.usermanage.model.Statement;
import com.naggaro.usermanage.repository.StatementRepository;

@Service
public class StatementService {
	@Autowired
	private StatementRepository statementRepository;

	public List<Statement> getAllStatement() throws SQLException{
		
		List<Statement> statement = statementRepository.findAll();
		return statement;
	}
	
	public HashMap<String, Object> addStatement(Statement statement) throws SerialException, SQLException {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
	
		statement = statementRepository.save(statement);
		if(statement.getId() > 0) {
			map.put("Status", "Successfull");
			map.put("Success Code", "200");
			map.put("Id", statement.getId());
			
		}else {
			map.put("Status", "Failed");
			map.put("Error Code", "401");
			map.put("Id", 0);		
		}
		return map;
	}
	
	public Statement getStatement(long id) throws SQLException {
		
		Statement statement = statementRepository.getOne(id);	
		return statement;	
	}
	
	public HashMap<String, Object> updateStatement(Statement statement) throws SerialException, SQLException {
		HashMap<String, Object> map = new HashMap<String, Object>();
	
		statement = statementRepository.save(statement);
		if(statement.getId() > 0) {
			map.put("Status", "Successfull");
			map.put("Success Code", "200");
			map.put("Id", statement.getId());
			
		}else {
			map.put("Status", "Failed");
			map.put("Error Code", "401");
			map.put("Id", 0);		
		}
		return map;
	}
	
	public void deleteStatement(long id) {
		statementRepository.deleteById(id);
    }


}
