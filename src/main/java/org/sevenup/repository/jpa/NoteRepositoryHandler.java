package org.sevenup.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sevenup.domain.Note;
import org.sevenup.repository.NoteRepository;
import org.springframework.stereotype.Repository;

@Repository
class NoteRepositoryHandler implements NoteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Note> findAll() {
		return this.entityManager.createQuery("SELECT n FROM Note n", Note.class)
				.getResultList();
	}

}
