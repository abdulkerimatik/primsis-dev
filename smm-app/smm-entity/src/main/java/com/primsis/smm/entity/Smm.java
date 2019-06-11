package com.primsis.smm.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.primsis.core.entity.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author abdulkerim.ATIK
 *
 */
@Entity
@Table(name = "SMM")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public @Data class Smm  extends  BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1202339593306262050L;

	@Id
	@GeneratedValue(generator = "smm_gen")
	@SequenceGenerator(name = "smm_gen", sequenceName = "SEQ_SMM", allocationSize = 1, initialValue = 1)
	private Long id;

	@Column(name = "UUID")
	private String uuid;

	@Column(name = "SMM_ID")
	private String smmId;

	@Column(name = "REPORT_ID")
	private Long reportId;
	
	@Column(name = "OLD_REPORT_ID")
	private Long oldReportId;

	@Column(name = "FILESET_ID")
	private Long fileset;

	@Column(name = "TXN_ID")
	private Long txn;

	@Column(name = "ACCOUNT_ID")
	private Long accountId;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "SUB_STATUS")
	private String subStatus;

	@Column(name = "STATUS_CODE")
	private Long statusCode;

	@Column(name = "PROFILE_ID")
	private String profileId;
	
	@Column(name = "SENDING_TYPE")
	private String sendingType;

	@Column(name = "ISSUE_DATE")
	private Date issueDate;

	@Column(name = "ISSUE_TIME")
	private String issueTime;

	@Column(name = "DOCUMENT_TYPE_CODE")
	private String documentTypeCode;

	@Column(name = "DOC_CURRENCY_CODE")
	private String docCurrencyCode;

	@Column(name = "SUPPLIER_NAME")
	private String supplierName;

	@Column(name = "SUPPLIER_IDENTIFIER")
	private String supplierIdentifier;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "CUSTOMER_IDENTIFIER")
	private String customerIdentifier;

	@Column(name = "ERP_READ_FLAG")
	@Type(type = "org.hibernate.type.YesNoType")
	private boolean erpReadFlag;

	@Column(name = "REPORT_FLAG")
	private Character reportFlag;

	@Column(name = "LINE_COUNT")
	private Long lineCount;

	@Column(name = "PAYMENT_AMOUNT")
	private BigDecimal paymentAmount;

	@Column(name = "COPY_INDICATOR")
	@Type(type = "org.hibernate.type.YesNoType")
	private boolean copyIndicator;

	@Column(name = "SMM_PREFIX")
	private String smmPrefix;

	@Column(name = "OLD_SMM_ID")
	private String oldSmmId;

	@Column(name = "NEW_SMM_ID")
	private String newSmmId;

	@Column(name = "EVENT_MASK")
	private Long eventMask;

	@Column(name = "MAIL_FLAG")
	@Type(type = "org.hibernate.type.YesNoType")
	private boolean mailFlag;

	@Column(name = "MAIL")
	private String mail;

	@Column(name = "MAIL_STATUS")
	private String mailStatus;

	@Column(name = "MAIL_STATUS_DESC")
	private String mailStatusDesc;
	
	@Column(name = "MAIL_QUEUE_ID")
	private String mailQueueId;

	@Column(name = "APP_QUEUE_ID")
	private Long appQueueID;

	@Column(name = "TAGS")
	private String tags;
	
	@Column(name = "NO_REPORT_FLAG")
	private Character noReportFlag;
	
	@Column(name = "CANCEL_REPORT_FLAG")
	private Character cancelReportFlag;
	
	@Column(name = "CANCEL_SMM_DATE")
	private Date  cancelSmmDate;

	@Column(name = "OP_REVIEW_CODE")
	private Long opReviewCode;

	@Column(name = "OP_REVIEW_NOTE")
	private String opReviewNote;

	@Column(name = "OP_REVIEW_DATE")
	private Date opReviewDate;
	
	

}
