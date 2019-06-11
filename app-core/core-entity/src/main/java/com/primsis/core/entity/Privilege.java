package com.primsis.core.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.primsis.core.entity.User.UserBuilder;
import com.primsis.core.entity.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Abdulkerim.Atik
 *
 */
@Entity
@Table(name = "CF_PRIVILEGE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public @Data class Privilege extends BaseEntity {

	private static final long serialVersionUID = 4535072681279576640L;

	@Id
	@GeneratedValue(generator = "privilege_gen")
	@SequenceGenerator(name = "privilege_gen", sequenceName = "SEQ_PRIVILEGE")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

}
