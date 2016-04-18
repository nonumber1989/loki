package org.sevenup.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class CollerberationRoom extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
//	private List<Participant> participants;
	private Date dueDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	} 
	
}
