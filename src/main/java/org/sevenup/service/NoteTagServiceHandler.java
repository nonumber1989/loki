package org.sevenup.service;

import java.util.List;

import org.sevenup.domain.Note;
import org.sevenup.domain.Tag;
import org.sevenup.repository.NoteRepository;
import org.sevenup.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class NoteTagServiceHandler implements NoteTagService {
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private TagRepository tagRepository;

	@Override
	public List<Note> findAllNote() {
		return noteRepository.findAll();
	}

	@Override
	public List<Tag> findAllTag() {
		return tagRepository.findAll();
	}

}
