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
@Table(name = "CUSTOMER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public  @Data class Customer extends BaseEntity  {

	private static final long serialVersionUID = -8271884664175064238L;

	@Id
	@GeneratedValue(generator = "customer_gen")
	@SequenceGenerator(name = "customer_gen", sequenceName = "SEQ_CUSTOMER",allocationSize = 1, initialValue= 1)
	private Long id;
	
	@Column(name = "COMMERCIAL_NAME")
	private String commercialName;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "VKN_TCKNO")
	private String vknTckno;
	
	@SuppressWarnings("deprecation")
	@Email
	private String email;
	
	private String website;
	
	@Column(name = "TAX_OFFICE")
	private String taxOffice;
	private String status;
	
	@Column(name = "SUB_STATUS")
	private String subStatus;
	
	private String remark;
	
	@Column(name = "CUSTOMER_TYPE")
	private String customerType;
	
	@Column(name = "CONFIG_TYPE")
	private String configType;
	
	@Column(name = "COMPANY_TYPE")
	private String companyType;
	
	@Column(name = "TARIFF_TYPE")
	private Long tariffType;
	
	@Column(name = "TARIFF_TYPE_CODE")
	private Long tariffTypeCode;
	
	
	@Column(name = "VB_SE_FLAG")
	private String vbSeFeeFlag;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CHANNEL_REF")
	private Customer channelRef;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "DEALER_REF")
	private Customer dealerRef;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_REF")
	private Account accountRef;

	@Builder.Default
	@OneToMany(mappedBy = "customer",fetch=FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Account> accountList = new ArrayList<Account>();
	
	
	@Builder.Default
	@OneToMany(mappedBy = "customer",fetch=FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Address> addressList = new ArrayList<Address>();

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "PARENT_CUSTOMER_ID")
	private Customer parent;
	
	private String nick;
	
	@Column(name = "SICIL_NO")
	private String sicilNo;
	
	@Column(name = "ISLETME_MERKEZI")
	private String isletmeMerkezi;
	
	@Column(name = "MERSIS_NO")
	private String mersisNo;

	@Column(name = "CONTRACT_SIGNED")
	@Type(type = "org.hibernate.type.YesNoType")
	private Boolean contractSigned;
	
	@Column(name = "ACTIVATION_REASON")
	private String activationReason;
	
	@Column(name = "DEACTIVATION_REASON")
	private String deactivationReason;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMITMENT_START_DATE")
	private Date commitmentStartDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMITMENT_END_DATE")
	private Date commitmentEndDate;
}
