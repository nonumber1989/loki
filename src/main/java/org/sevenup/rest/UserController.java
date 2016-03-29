package org.sevenup.rest;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.sevenup.domain.User;
import org.sevenup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	// @RequestMapping(method = RequestMethod.GET)
	// public Map<User, Long> getUsers(@PageableDefault(page = 0, size = 10)
	// Pageable pageable,
	// @SortDefault(sort = "name", direction = Sort.Direction.DESC) Sort sort,
	// @RequestParam(value = "memberId", required = false) String id) {
	// List<User> users = (List<User>) userRepository.findAll();
	// //
	// users.stream().filter(user->user.getAge()==3).distinct().collect(Collectors.toList());
	// Map<User, Long> groupMap = users.stream()
	// .collect(Collectors.groupingBy(Function.identity(),
	// Collectors.counting()));
	// return groupMap;
	// }

	@RequestMapping(method = RequestMethod.GET)
	public Map<User, Long> getUsers(
			@PageableDefault(page = 0, size = 10, sort = "name", direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(value = "memberId", required = false) String id) {
		List<User> users = (List<User>) userRepository.findAll();
		// users.stream().filter(user->user.getAge()==3).distinct().collect(Collectors.toList());
		Map<User, Long> groupMap = users.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return groupMap;
	}

	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public User getUserById(@PathVariable Long id) {
		return userRepository.findOne(id);
	}
}
