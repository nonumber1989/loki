package org.sevenup.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Basic
	private Date createDate;
	@Basic
	private Date modifyDate;

	@PrePersist
	public void prePersist() {
		this.setCreateDate(new Date());
		this.setModifyDate(new Date());
	}

	@PreUpdate
	public void preUpdate() {
		this.setModifyDate(new Date());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
//    @JsonIgnore
//	public boolean isNew() {
//		return (this.id == null);
//	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
