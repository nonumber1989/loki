package org.sevenup.rest;

import java.util.List;

import org.sevenup.domain.Note;
import org.sevenup.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LokiController {
	@Autowired
	private NoteRepository noteRepository;
	@RequestMapping("/")
	public List<Note> getNotes() {
		List<Note> notes = this.noteRepository.findAll();
		return notes;
	}

}