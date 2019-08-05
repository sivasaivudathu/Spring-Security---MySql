package com.springsecurity.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

    Role  findRoleByRoleName(String roleName);
}
