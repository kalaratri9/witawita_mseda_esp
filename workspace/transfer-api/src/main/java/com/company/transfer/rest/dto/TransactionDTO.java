package com.company.transfer.rest.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The Class TransactionDTO.
 */
public class TransactionDTO {
	
	/** The destination account id. */
	private Long destinationAccountId;
	
	/** The amount. */
	private BigDecimal amount;
	
	/** The description. */
	private String description;
		
	/** The creation datetime. */
	private Date creationDatetime;
	
	/** The transfer status. */
	private String transferStatus;
	
	/**
	 * Instantiates a new transaction DTO.
	 */
	public TransactionDTO() {
		super();
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
	 * Gets the transfer status.
	 *
	 * @return the transfer status
	 */
	public String getTransferStatus() {
		return transferStatus;
	}

	/**
	 * Sets the transfer status.
	 *
	 * @param transferStatus the new transfer status
	 */
	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

}
