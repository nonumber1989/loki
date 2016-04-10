package org.sevenup.service;

import org.sevenup.domain.User;
import org.sevenup.repository.springdata.UserDefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceHandler implements UserService {
	@Autowired
	private UserDefaultRepository userRepository;

	@Override
	public Page<User> findByPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

}
