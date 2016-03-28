package org.sevenup.repository;

import java.util.List;

import org.sevenup.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

//public interface UserRepository extends CrudRepository<User, Long> {
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	List<User> findByName(String name);
}