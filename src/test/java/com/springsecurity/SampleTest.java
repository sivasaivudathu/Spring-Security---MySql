package com.springsecurity;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.springsecurity.model.Role;
import com.springsecurity.model.User;
import com.springsecurity.repositories.UsersRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

	@Autowired
	UsersRepository rep;

	@Test
	public void save() {
		
		User usr = new  User();
		
		usr.setFirstName("SURYA");
		usr.setIsActive(1);
		usr.setLastName("S");
		String password = new BCryptPasswordEncoder().encode("12345");
		usr.setPassword(password);
		
		Role role = new Role();
		
		role.setRoleName("ADMIN");
		
		HashSet<Role> roles = new HashSet<Role>();
		roles.add(role);
		usr.setRoles(roles);
		
		rep.save(usr);
	}
}
