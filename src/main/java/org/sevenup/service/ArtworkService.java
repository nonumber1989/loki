package org.sevenup.service;

import org.sevenup.domain.Artwork;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArtworkService {
	public Page<Artwork> findByPageable(Pageable pageable);

	public  Artwork  save(Artwork entity);

//	public <S extends Artwork> Iterable<S> save(Iterable<S> entities);

	public Artwork findById(Long id);

	public boolean exists(Long id);

//	public Iterable<User> findAll(Iterable<Long> ids);

	public long count();

	public Artwork delete(Long id);

}
