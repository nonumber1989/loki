package org.sevenup.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Here is a tricky If you want to use the Spring Data default
 * SimpleJpaRepository implementation Just extends this basic service by generic
 * , the you no need to create new interface
 * 
 * @author Steven.Xu
 * 
 * @param <T>
 * @param <ID>
 */
public class LokiService<T, ID extends Serializable> {
	@Autowired
	protected PagingAndSortingRepository<T, ID> repository;
}
