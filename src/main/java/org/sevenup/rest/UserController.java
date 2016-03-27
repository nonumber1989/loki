package org.sevenup.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.sevenup.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		for(int i=0;i<100;i++){
			User user = new User();
			user.setAge(i);
			user.setId(i);
			user.setName("name"+i);
			users.add(user);
		}
		return users.stream().filter(user-> user.getAge()<10).collect(Collectors.toList());
	}
}
