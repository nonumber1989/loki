package org.sevenup.dto;

import java.util.List;

public class TagDTO {
	private String name;
	private List<NoteDTO> notes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<NoteDTO> getNotes() {
		return notes;
	}
	public void setNotes(List<NoteDTO> notes) {
		this.notes = notes;
	}
	
}
