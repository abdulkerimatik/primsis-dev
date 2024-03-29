package com.primsis.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.primsis.core.entity.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * UserSessionToken generated by hbm2java
 */
/**
 * @author abdulkerim.ATIK
 *
 */

@Entity
@Table(name = "USER_SESSION_TOKEN")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public @Data class UserSessionToken extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7526275672805714306L;

	@Id
	@GeneratedValue(generator = "gen_user_session_token")
	@SequenceGenerator(name = "gen_user_session_token", sequenceName = "SEQ_USER_SESSION_TOKEN", allocationSize = 1, initialValue = 1)
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	private Long id;
	
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "SESSION_ID", length = 256)
	private String sessionId;

	@Column(name = "TOKEN", length = 1024)
	private String token;
	
	@Column(name = "AUTH_INFO", length = 4000)
	private String authInfo;

	@Column(name = "EXPIRED")
	private Long expiredTime;

	
}
