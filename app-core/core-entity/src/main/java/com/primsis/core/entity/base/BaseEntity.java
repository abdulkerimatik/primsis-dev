package com.primsis.core.entity.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.primsis.core.entity.User;

import lombok.Data;

/**
 * @author Abdulkerim.Atik
 *
 */
@MappedSuperclass
public @Data class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CDATE")
	private LocalDateTime createDate;

	@Column(name = "UDATE")
	private LocalDateTime modifyDate;

	@ManyToOne
	@JoinColumn(name = "CUSER_ID")
	private User createUser;

	@ManyToOne
	@JoinColumn(name = "UUSER_ID")
	private User modifyUser;

	@PrePersist
	protected void onCreate() {
		createDate = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyDate = LocalDateTime.now();
	}

}
