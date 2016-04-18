package org.sevenup.repository.springdata;

import org.sevenup.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDefaultRepository extends PagingAndSortingRepository<User,Long>{

}
