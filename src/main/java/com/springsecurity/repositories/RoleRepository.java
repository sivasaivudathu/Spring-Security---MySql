package com.springsecurity.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.model.Role;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer>{

    Role  findRoleByRoleName(String roleName);
}
