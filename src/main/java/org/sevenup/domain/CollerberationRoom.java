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
	private List<Participant> participants;
	private Date createDate;
	private Date dueDate; 
}
