package org.sevenup.repository.jpa;

import org.sevenup.domain.User;
import org.sevenup.repository.UserRepository;
import org.sevenup.repository.common.LokiPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryHandler extends LokiPagingAndSortingRepository<User, Long> implements UserRepository {

}
