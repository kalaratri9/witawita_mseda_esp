package com.company.transfer.rest.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.company.transfer.service.model.entities.ExternalTransfer;
import com.sun.istack.NotNull;

/**
 * The Class ExternalTransferDTO.
 */
public class ExternalTransferDTO extends TransferDTO {
	
	/** The reference number. */
	@NotNull
	private Long referenceNumber;

	/**
	 * Instantiates a new external transfer DTO.
	 */
	public ExternalTransferDTO() {
		super();
	}
	
	/**
	 * Gets the reference number.
	 *
	 * @return the reference number
	 */
	public Long getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * Sets the reference number.
	 *
	 * @param referenceNumber the new reference number
	 */
	public void setReferenceNumber(Long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
		
	/**
	 * To external transfer.
	 *
	 * @return the external transfer
	 */
	public ExternalTransfer toExternalTransfer() {
		ExternalTransfer transfer = new ExternalTransfer();
		transfer.setAmount(BigDecimal.valueOf(getAmount()));
		transfer.setDescription(getDescription());
		transfer.setReferenceNumber(BigInteger.valueOf(referenceNumber));		
		return transfer;
	}
	
}