package com.primsis.core.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

import com.primsis.core.entity.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public @Data  class Address extends BaseEntity {

	private static final long serialVersionUID = -8589345176025125158L;

	@Id
	@GeneratedValue(generator = "address_gen")
	@SequenceGenerator(name = "address_gen", sequenceName = "SEQ_ADDRESS",allocationSize = 1, initialValue= 1)
	private Long id;
	
	@Column(name = "CONTACT")
	private String contact;
	
	@Column(name = "VKN_TCKN")
	private String vknTckno;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "CITY_STR")
	private String city;
	
	@Column(name = "DISTRICT_STR")
	private String district;
	
	@Column(name = "STREET")
	private String street;
	
	
	@Column(name = "BUILDING_NO")
	private String buildingNo;
	
	
	@Column(name = "HOUSE_NO")
	private String houseNo;
	
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	
	@Column(name = "TELNO")
	private String telno;
	
	@Column(name = "FAXNO")
	private String faxno;
	
	@Column(name = "BUILDING_NAME")
	private String buildingName;
	
	@Column(name = "SUB_CITY")
	private String subCity;
	
	@SuppressWarnings("deprecation")
	@Email
	private String email;
	
	@Column(name = "DEFAULT_GIB_PK")
	private String defaultPK;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinTable(name = "ACCOUNT_ADDRESS", joinColumns = { @JoinColumn(name = "ADDRESS_ID") }, inverseJoinColumns = { @JoinColumn(name = "ACCOUNT_ID") })
	private Account account;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinTable(name = "CUSTOMER_ADDRESS", joinColumns = { @JoinColumn(name = "ADDRESS_ID") }, inverseJoinColumns = { @JoinColumn(name = "CUSTOMER_ID") })
	private Customer customer;
}
