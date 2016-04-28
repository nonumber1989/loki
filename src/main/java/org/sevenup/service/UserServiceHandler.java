package org.sevenup.service;

import java.util.Map;
import java.util.Set;

import org.sevenup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceHandler implements UserService{
	@Autowired
	private PagingAndSortingRepository<User,Long> userRepository;
	@Override
	public Page<User> findByPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Map<Long, Set<User>> findUsersGroupBy() {
		return null;
	}

}
