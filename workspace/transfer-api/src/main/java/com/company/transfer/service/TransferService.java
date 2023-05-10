package com.company.transfer.service;

import com.company.transfer.rest.dto.ExternalTransferCreatedDTO;
import com.company.transfer.rest.dto.ExternalTransferDTO;
import com.company.transfer.utilities.exceptions.TransferBadRequestException;
import com.company.transfer.utilities.exceptions.TransferException;
import com.company.transfer.utilities.exceptions.TransferForbiddenException;
import com.company.transfer.utilities.exceptions.TransferLockedException;
import com.company.transfer.utilities.exceptions.TransferResourceNotFoundException;

/**
 * The Interface TransferService.
 */
public interface TransferService {	
	
	/**
	 * Creates the external transfer.
	 *
	 * @param accountId the account id
	 * @param externalTransferDTO the external transfer DTO
	 * @return the external transfer created DTO
	 * @throws TransferResourceNotFoundException the transfer resource not found exception
	 * @throws TransferException the transfer exception
	 * @throws TransferBadRequestException the transfer bad request exception
	 * @throws TransferLockedException the transfer locked exception
	 * @throws NumberFormatException the number format exception
	 * @throws TransferForbiddenException the transfer forbidden exception
	 */
	ExternalTransferCreatedDTO createExternalTransfer(Long accountId, ExternalTransferDTO externalTransferDTO)
			throws TransferResourceNotFoundException, TransferException, TransferBadRequestException,
			TransferLockedException, NumberFormatException, TransferForbiddenException;

}