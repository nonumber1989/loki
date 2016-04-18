package org.sevenup.repository.common;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

public interface LokiPagingAndSortingRepository<T, ID extends Serializable> {
	Iterable<T> findBySort(Sort sort);

	Page<T> findByPage(Pageable pageable);
}
