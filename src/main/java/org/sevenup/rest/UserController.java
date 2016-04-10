package org.sevenup.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.sevenup.common.exception.ResourceNotFoundException;
import org.sevenup.domain.User;
import org.sevenup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
	private UserService userService;

	/**
	 * the example /users?page=0&size=20&sort=id,desc&sort=name,asc
	 * 
	 * @param pageable
	 * @param id
	 * @return Pager
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Page<User> getPageableUsers(
			@PageableDefault(page = 0, size = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> pageUser = userService.findByPageable(pageable);
		return pageUser;
	}

	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public Map<User, Long> getGroupedUsers(@RequestParam(value = "group", required = false) String group) {
		List<User> users = (List<User>) userService.findByPageable(null);
		Map<User, Long> groupMap = users.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return groupMap;
	}

	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@Valid @RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		userService.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Long id) {
		Optional<User> user = Optional.ofNullable(userService.findById(id));
		return user.orElseThrow(ResourceNotFoundException::new);
	}
}
