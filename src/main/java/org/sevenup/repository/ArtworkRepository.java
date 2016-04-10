package org.sevenup.repository;

import org.sevenup.domain.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
//extends JpaRepository<Artwork, Long>,JpaSpecificationExecutor<Artwork>
public interface ArtworkRepository  {

//	public Page<Artwork> findByPageable(Pageable pageable);

//	public <S extends Artwork> S save(S entity);

//	public <S extends Artwork> Iterable<S> save(Iterable<S> entities);

//	public User findById(Long id);

//	public boolean exists(Long id);

//	public Iterable<User> findAll(Iterable<Long> ids);

	public long count();

	public void xxxx(Long id);

}