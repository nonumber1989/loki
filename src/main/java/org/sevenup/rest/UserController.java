//package org.sevenup.rest;
//
//import java.util.Map;
//import java.util.Optional;
//import java.util.Set;
//
//import javax.validation.Valid;
//
//import org.sevenup.common.exception.ResourceNotFoundException;
//import org.sevenup.domain.EntityVisibility;
//import org.sevenup.domain.User;
//import org.sevenup.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefaults;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.annotation.JsonView;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//	@Autowired
//	private UserService userService;
//
//	/**
//	 * the example /users?page=0&size=20&sort=id,desc&sort=name,asc
//	 * 
//	 * @param pageable
//	 * @param id
//	 * @return Pager
//	 */
//	@RequestMapping(method = RequestMethod.GET)
//	public Page<User> getPageableUsers(
//			@PageableDefaults(pageNumber = 0, value = 10, sortDir = Sort.Direction.DESC) Pageable pageable) {
//		Page<User> pageUser = userService.findByPageable(pageable);
//		return pageUser;
//	}
//
//	@RequestMapping(value = "/group", method = RequestMethod.GET)
//	public Map<Long, Set<User>> getGroupedUsers(@RequestParam(value = "group", required = false) String group) {
//		Map<Long, Set<User>> groupMap = userService.findUsersGroupBy();
//		return groupMap;
//	}
//	
//	@JsonView(EntityVisibility.Public.class)
//	@RequestMapping(method = RequestMethod.POST)
//	public User createUser(@Valid @RequestBody User user) {
//		return userService.save(user);
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public void deleteUser(@PathVariable Long id) {
//		userService.delete(id);
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public User getUserById(@PathVariable Long id) {
//		Optional<User> user = Optional.ofNullable(userService.findById(id));
//		return user.orElseThrow(ResourceNotFoundException::new);
//	}
//}
