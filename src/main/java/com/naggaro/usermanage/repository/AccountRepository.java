package com.naggaro.usermanage.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.naggaro.usermanage.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

}
