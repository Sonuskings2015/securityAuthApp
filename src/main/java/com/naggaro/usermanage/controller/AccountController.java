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

import com.naggaro.usermanage.model.Account;
import com.naggaro.usermanage.security.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;  
	   
	@GetMapping("/account/{id}")   
	private Account getAccount(@PathVariable("id") long id) throws SQLException   
	{  
		return accountService.getAccount(id);   
	}  
	
	@GetMapping("/account/{id}")
	public List<Account> getAllAccount() throws SQLException {
		return accountService.getAllAccount();
	}
	
	@DeleteMapping("/account/{id}")  
	private void deleteAccount(@PathVariable("id") long id)   
	{  
		accountService.deleteAccount(id);
	} 
	
	@PostMapping("/account/{id}") 
	public HashMap<String, Object> addAccount(@RequestBody Account account) throws SerialException, SQLException  {
		return accountService.addAccount(account);
	}
	
	@PutMapping("/account/{id}")
	public HashMap<String, Object> updateAccount(@RequestBody Account account) throws SerialException, SQLException {  
		return accountService.updateAccount(account);
	}
}
