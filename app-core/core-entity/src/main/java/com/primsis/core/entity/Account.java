package com.primsis.core.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;

import com.primsis.core.entity.Address.AddressBuilder;
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
@Table(name = "ACCOUNT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public @Data class Account extends BaseEntity {

	private static final long serialVersionUID = -4612994571839714476L;

	@Id
	@GeneratedValue(generator = "account_gen")
	@SequenceGenerator(name = "account_gen", sequenceName = "SEQ_ACCOUNT", allocationSize = 1, initialValue = 1)
	private Long id;

	@Column(name = "COMMERCIAL_NAME")
	private String commercialName;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "VKN_TCKNO")
	private String vknTckno;

	@Email
	private String email;

	private String website;

	@Column(name = "TAX_OFFICE")
	private String taxOffice;

	private String status;

	@Column(name = "SUB_STATUS")
	private String subStatus;

	private String remark;

	@Builder.Default
	@Column(name = "NOTIFY_MSG_MASK_EMAIL")
	private Long notifyEmailMask = 0L;

	@Builder.Default
	@Column(name = "NOTIFY_MSG_MASK_SMS")
	private Long notifySmsMask = 0L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Builder.Default
	@OneToMany(mappedBy = "account", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<User> userList = new ArrayList<>();

	@Builder.Default
	@Column(name = "ANNUNCIATION_FLAG")
	@Type(type = "org.hibernate.type.YesNoType")
	private Boolean annunciationFlag = Boolean.FALSE;

	
	
	

}
