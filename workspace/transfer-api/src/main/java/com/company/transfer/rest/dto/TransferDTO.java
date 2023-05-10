package com.company.transfer.rest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

/**
 * The Class TransferDTO.
 */
public class TransferDTO {

	/** The destination account id. */
	@NotNull(message = "destinationAccountId cannot be null")
	private Long destinationAccountId;

	/** The amount. */
	@NotNull(message = "amount cannot be null")
	private Double amount;

	/** The description. */
	@Size(min = 1, max = 40, message = "description must be equal or greater than 1 and less than 40 characters")
	@NotBlank(message = "description cannot be null or empty")
	@Pattern(regexp = "[a-zA-Z0-9 ]*", message = "not special characters")
	@ApiModelProperty(required = true, dataType = "java.lang.String", example = "description", value = "Description.<br>")
	private String description;

	/**
	 * Instantiates a new transfer DTO.
	 */
	public TransferDTO() {
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
	public Double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Double amount) {
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

}
