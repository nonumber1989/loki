package org.sevenup.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	// @JsonIgnore
	@Version
	private Long version;

	@Basic
	@JsonIgnore
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Basic
	@JsonIgnore
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
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