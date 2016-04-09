package org.sevenup.repository;

import org.sevenup.domain.Artwork;
import org.sevenup.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArtworkRepository {

	public Page<Artwork> findByPageable(Pageable pageable);

	public <S extends User> S save(S entity);

//	public <S extends User> Iterable<S> save(Iterable<S> entities);

	public User findById(Long id);

	public boolean exists(Long id);

//	public Iterable<User> findAll(Iterable<Long> ids);

	public long count();

	public void delete(Long id);

}