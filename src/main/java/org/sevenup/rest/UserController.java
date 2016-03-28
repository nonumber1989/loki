package org.sevenup.rest;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.sevenup.domain.User;
import org.sevenup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@RequestMapping(method = RequestMethod.GET)
	public Map<User, Long> getUsers(){
		List<User> users = (List<User>) userRepository.findAll();
//		 return users.stream().filter(user->user.getAge()==3).distinct().collect(Collectors.toList());
		Map<User, Long> groupMap = users.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return groupMap;
	}
}
