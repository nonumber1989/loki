package org.sevenup.repository;

import org.sevenup.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long>{ 

}
