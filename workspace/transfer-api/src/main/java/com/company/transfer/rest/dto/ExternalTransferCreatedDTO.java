package com.company.transfer.rest.dto;

import java.math.BigInteger;

import com.company.transfer.service.model.entities.ExternalTransfer;

/**
 * The Class ExternalTransferCreatedDTO.
 */
public class ExternalTransferCreatedDTO extends TransactionDTO {

	/** The external transfer id. */
	private Long externalTransferId;

	/** The reference number. */
	private BigInteger referenceNumber;

	/**
	 * Instantiates a new external transfer created DTO.
	 */
	public ExternalTransferCreatedDTO() {
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
	 * From external transfer.
	 *
	 * @param e the e
	 * @return the external transfer created DTO
	 */
	public static ExternalTransferCreatedDTO fromExternalTransfer(ExternalTransfer e) {
		ExternalTransferCreatedDTO dto = new ExternalTransferCreatedDTO();
		dto.setExternalTransferId(e.getExternalTransferId());
		dto.setAmount(e.getAmount());
		dto.setCreationDatetime(e.getCreationDatetime());
		dto.setDescription(e.getDescription());
		dto.setDestinationAccountId(e.getDestinationAccountId());
		dto.setReferenceNumber(e.getReferenceNumber());
		dto.setTransferStatus(e.getTransferStatus().name());
		return dto;
	}

}
