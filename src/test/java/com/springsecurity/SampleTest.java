package com.springsecurity;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
		
		usr.setFirstName("DINESH");
		usr.setIsActive(1);
		usr.setLastName("S");
		usr.setPassword("$2a$10$pnty63IkJgeQVRpvIUSl7uRQ2/33YmqzyT8ZfKGLHoukEc5aeZud");
		
		Role role = new Role();
		
		role.setRoleName("ADMIN");
		
		HashSet<Role> roles = new HashSet<Role>();
		roles.add(role);
		usr.setRoles(roles);
		
		rep.save(usr);
	}
}
