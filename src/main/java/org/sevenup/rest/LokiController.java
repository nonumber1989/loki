package org.sevenup.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.sevenup.domain.Note;
import org.sevenup.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class LokiController {
	@Autowired
	private NoteRepository noteRepository;
    @RequestMapping(method = RequestMethod.GET)
	public List<Note> getNotes() {
		List<Note> notes = this.noteRepository.findAll();
		List<Note> notes2 =  notes.stream().filter(note -> note.getId()== 1).collect(Collectors.toList());
		return notes;
	}
	@RequestMapping("/1")
	public Note getNote(){
		List<Note> notes = this.noteRepository.findAll();
		return notes.get(0);
	}
	
	

}