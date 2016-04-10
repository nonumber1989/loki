package org.sevenup.service;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.sevenup.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceHandler extends LokiService<User,Long> implements UserService {
//	@Autowired
//	private UserDefaultRepository userRepository;

	@Override
	public Page<User> findByPageable(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional
	public User save(User entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public User findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Map<Long, Set<User>> findUsersGroupBy() {
		List<User> users = (List<User>) repository.findAll();
		Map<Long, List<User>> groupList = users.stream().collect(Collectors.groupingBy(User::getId));
		Map<Long, Set<String>> groupSetString = users.stream()
				.collect(Collectors.groupingBy(User::getId, Collectors.mapping(User::getName, Collectors.toSet())));
		Map<Long, Set<User>> groupSet = users.stream().collect(Collectors.groupingBy(User::getId, Collectors.toSet()));
		LongSummaryStatistics statistic = users.stream().collect(Collectors.summarizingLong(User::getId));
		return groupSet;
	}

}
