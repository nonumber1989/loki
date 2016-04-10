package org.sevenup.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


@MappedSuperclass
public class BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

//	@Version
//	private int version;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
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
	// @JsonIgnore
	// public boolean isNew() {
	// return (this.id == null);
	// }

	public Date getCreateDate() {
		return createDate;
	}

//	public int getVersion() {
//		return version;
//	}
//
//	public void setVersion(int version) {
//		this.version = version;
//	}

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
