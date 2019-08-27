package com.springsecurity;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.springsecurity.model.Role;
import com.springsecurity.model.User;
import com.springsecurity.repositories.RoleRepository;
import com.springsecurity.repositories.UsersRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

	@Autowired
	UsersRepository rep;
	
	@Autowired
	RoleRepository rolerepo;
	

	@Test
	@Transactional
	public void save() {
		
		User usr = new  User();
		
		usr.setFirstName("SAI");
		usr.setIsActive(1);
		usr.setLastName("S");
		String password = new BCryptPasswordEncoder().encode("12345");
		usr.setPassword(password);
		
		Role role = getRole("ADMIN");
		
		//role.setRoleName("ADMIN");
		
		HashSet<Role> roles = new HashSet<Role>();
		roles.add(role);
		usr.setRoles(roles);
		
		rep.saveAndFlush(usr);
		
		
		
	}
	
	public Role getRole(String roleName){
		return rolerepo.findRoleByRoleName(roleName);
	}
}
