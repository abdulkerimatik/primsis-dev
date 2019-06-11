package com.primsis.core.entity;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public @Data class User extends BaseEntity implements UserDetails {

	private static final long serialVersionUID = 8785534197851028173L;

	@Id
	@GeneratedValue(generator = "user_gen")
	@SequenceGenerator(name = "user_gen", sequenceName = "SEQ_USERS", allocationSize = 1, initialValue = 1)
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@SuppressWarnings("deprecation")
	@Email
	private String email;

	@Builder.Default
	@Column(name = "ACTIVE")
	@Type(type = "org.hibernate.type.YesNoType")
	private Boolean active = Boolean.FALSE;

	@Column(name = "ACTIVATION_KEY")
	private String activationKey;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;

	@Builder.Default
	@Column(name = "THEME")
	private String theme = "AquaTopbar";

	@Builder.Default
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "USER_PRIVILEGES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {@JoinColumn(name = "PRIVILEGE_ID") })
	private List<Privilege> privileges = new ArrayList<>();

	
	@Builder.Default
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID") })
	private List<Role> roles = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	     List<GrantedAuthority> authorities = new ArrayList<>();
	     return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return active;
	}

	@Override
	public boolean isAccountNonLocked() {
		return active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return active;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

}






	

