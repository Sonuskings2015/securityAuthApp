package com.naggaro.usermanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naggaro.usermanage.model.Statement;

public interface StatementRepository extends JpaRepository<Statement,Long>{

}
