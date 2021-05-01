package com.naggaro.usermanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naggaro.usermanage.model.Role;
import com.naggaro.usermanage.model.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName roleName);
}
