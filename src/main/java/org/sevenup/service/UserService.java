package org.sevenup.service;

import java.util.Map;
import java.util.Set;

import org.sevenup.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
	Page<User> findByPageable(Pageable pageable);

	User save(User entity);

	void delete(Long id);

	User findById(Long id);
	
	Map<Long, Set<User>> findUsersGroupBy();
}
