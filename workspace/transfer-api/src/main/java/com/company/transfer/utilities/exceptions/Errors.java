package com.company.transfer.utilities.exceptions;

/**
 * The Enum Errors.
 */
public enum Errors {
	
	/** The invalid destination account dto. */
	INVALID_DESTINATION_ACCOUNT_DTO(400.1, "Missing data: [%s]."),
	
	/** The invalid external transfer dto. */
	INVALID_EXTERNAL_TRANSFER_DTO(400.2, "Missing data: [%s]."),
	
	/** The invalid internal transfer dto. */
	INVALID_INTERNAL_TRANSFER_DTO(400.3, "Missing data: [%s]."),
	
	/** The invalid internal transfer same owner dto. */
	INVALID_INTERNAL_TRANSFER_SAME_OWNER_DTO(400.4, "Missing data: [%s]."),
	
	/** The invalid account data dto. */
	INVALID_ACCOUNT_DATA_DTO(400.5, "Missing data: [%s]."),
	
	/** The failed transfer. */
	FAILED_TRANSFER(400.6, "The transfer could not be made."),
	
	/** The totp header required. */
	TOTP_HEADER_REQUIRED(400.7, "X-USER-TOTP header is required."),
	
	/** The client core required. */
	CLIENT_CORE_REQUIRED(400.8, "ClientCoreId from securityHelper is required."),
	
	/** The clabe is not found. */
	CLABE_IS_NOT_FOUND(400.9, "This CLABE is not found, please try with the account number."),
	
	/** The invalid update destination accounts dto. */
	INVALID_UPDATE_DESTINATION_ACCOUNTS_DTO(400.10, "Missing data: [%s]."),

	/** The invalid investment dto. */
	INVALID_INVESTMENT_DTO(400.11, "Missing data: [%s]."),
	
	/** The duplicate move. */
	DUPLICATE_MOVE(400.12, "Duplicate move."),
	
	/** The limit amount per operation. */
	LIMIT_AMOUNT_PER_OPERATION(400.13, "Limit amount of $%s per operation."),
	
	/** The product without investment. */
	PRODUCT_WITHOUT_INVESTMENT(400.14, "Product without investment contract."),
	
	/** The wrong account. */
	WRONG_ACCOUNT(403.1, "The account doesn't belong to the given customer."),

	/** The invalid totp. */
	INVALID_TOTP(403.2, "TOTP validation failed."),
	
	/** The customer not found. */
	CUSTOMER_NOT_FOUND(404.1, "Customer not found."),
	
	/** The bank customer data no exist. */
	BANK_CUSTOMER_DATA_NO_EXIST(404.2, "There is no bank customer data."),
	
	/** The account not found. */
	ACCOUNT_NOT_FOUND(404.3, "Account not found."),
	
	/** The destination account not found. */
	DESTINATION_ACCOUNT_NOT_FOUND(404.4, "Destination account not found."),
	
	/** The catalog bank not found. */
	CATALOG_BANK_NOT_FOUND(404.5, "Catalog bank not found."),
	
	/** The account data not found. */
	ACCOUNT_DATA_NOT_FOUND(404.6, "Account data not found."),
	
	/** The external transfer not found. */
	EXTERNAL_TRANSFER_NOT_FOUND(404.7, "External transfer not found."),
	
	/** The internal transfer not found. */
	INTERNAL_TRANSFER_NOT_FOUND(404.8, "Internal transfer not found."),
	
	/** The internal transfer same owner not found. */
	INTERNAL_TRANSFER_SAME_OWNER_NOT_FOUND(404.9, "Internal transfer same owner not found."),
	
	/** The spei out of hours. */
	SPEI_OUT_OF_HOURS(423.1, "SPEI out of hours."),
	
	/** The system error. */
	SYSTEM_ERROR(500.1, "There was an error in the server. Try later."),
	
	/** The datatype error. */
	DATATYPE_ERROR(500.2, "Error in data type for this parameter."),
	
	/** The converter error. */
	CONVERTER_ERROR(500.3, "Error in data type converter.");
    
	/** The code. */
	private double code;
	
	/** The message. */
	private String message;

	/**
	 * Instantiates a new errors.
	 *
	 * @param code the code
	 * @param message the message
	 */
	private Errors(double code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public double getCode() {
		return code;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}