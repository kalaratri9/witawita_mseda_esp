package com.company.transfer.service.model.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class ExternalTransfer.
 */
@Entity
@Table(name = "external_transfer")
public class ExternalTransfer {

	/** The external transfer id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "external_transfer_id")
	private Long externalTransferId;

	/** The destination account id. */
	@Column(name = "destination_account_id")
	private Long destinationAccountId;

	/** The amount. */
	@Column(name = "amount")
	private BigDecimal amount;

	/** The description. */
	@Column(name = "description")
	private String description;
	
	/** The reference number. */
	@Column(name = "reference_number")
	private BigInteger referenceNumber;
	
	/** The transfer status. */
	@Column(name = "transfer_status")
	@Enumerated(EnumType.STRING)
	private TransferStatus transferStatus;
	
	/** The creation datetime. */
	@Column(name = "creation_datetime")
	private Date creationDatetime;

	/**
	 * Instantiates a new external transfer.
	 */
	public ExternalTransfer() {
		super();
	}

	/**
	 * Gets the external transfer id.
	 *
	 * @return the external transfer id
	 */
	public Long getExternalTransferId() {
		return externalTransferId;
	}

	/**
	 * Sets the external transfer id.
	 *
	 * @param externalTransferId the new external transfer id
	 */
	public void setExternalTransferId(Long externalTransferId) {
		this.externalTransferId = externalTransferId;
	}

	/**
	 * Gets the destination account id.
	 *
	 * @return the destination account id
	 */
	public Long getDestinationAccountId() {
		return destinationAccountId;
	}

	/**
	 * Sets the destination account id.
	 *
	 * @param destinationAccountId the new destination account id
	 */
	public void setDestinationAccountId(Long destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the reference number.
	 *
	 * @return the reference number
	 */
	public BigInteger getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * Sets the reference number.
	 *
	 * @param referenceNumber the new reference number
	 */
	public void setReferenceNumber(BigInteger referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	
	/**
	 * Gets the transfer status.
	 *
	 * @return the transfer status
	 */
	public TransferStatus getTransferStatus() {
		return transferStatus;
	}

	/**
	 * Sets the transfer status.
	 *
	 * @param transferStatus the new transfer status
	 */
	public void setTransferStatus(TransferStatus transferStatus) {
		this.transferStatus = transferStatus;
	}

	
	/**
	 * Gets the creation datetime.
	 *
	 * @return the creation datetime
	 */
	public Date getCreationDatetime() {
		return creationDatetime;
	}

	/**
	 * Sets the creation datetime.
	 *
	 * @param creationDatetime the new creation datetime
	 */
	public void setCreationDatetime(Date creationDatetime) {
		this.creationDatetime = creationDatetime;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ExternalTransfer [externalTransferId=" + externalTransferId + 
		       ", destinationAccountId=" + destinationAccountId + 
			   ", amount=" + amount	+ 
			   ", description=" + description + 
			   ", referenceNumber=" + referenceNumber + 
			   ", transferStatus=" + transferStatus	+ 
			   ", creationDatetime=" + creationDatetime + "]";
	}

}
