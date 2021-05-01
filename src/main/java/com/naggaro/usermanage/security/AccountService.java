package com.naggaro.usermanage.security;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naggaro.usermanage.model.Account;
import com.naggaro.usermanage.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAllAccount() throws SQLException{
		
		List<Account> account = accountRepository.findAll();
		return account;
	}
	
	public HashMap<String, Object> addAccount(Account account) throws SerialException, SQLException {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
	
		account = accountRepository.save(account);
		if(account.getId() > 0) {
			map.put("Status", "Successfull");
			map.put("Success Code", "200");
			map.put("Id", account.getId());
			
		}else {
			map.put("Status", "Failed");
			map.put("Error Code", "401");
			map.put("Id", 0);		
		}
		return map;
	}
	
	public Account getAccount(long id) throws SQLException {
		
		Account account = accountRepository.getOne(id);	
		return account;	
	}
	
	public HashMap<String, Object> updateAccount(Account account) throws SerialException, SQLException {
		HashMap<String, Object> map = new HashMap<String, Object>();
	
		account = accountRepository.save(account);
		if(account.getId() > 0) {
			map.put("Status", "Successfull");
			map.put("Success Code", "200");
			map.put("Id", account.getId());
			
		}else {
			map.put("Status", "Failed");
			map.put("Error Code", "401");
			map.put("Id", 0);		
		}
		return map;
	}
	
	public void deleteAccount(long id) {
		accountRepository.deleteById(id);
    }


}
