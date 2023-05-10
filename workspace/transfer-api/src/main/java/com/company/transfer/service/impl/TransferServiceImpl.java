package com.company.transfer.service.impl;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.commons.domain.events.transfer.TransferCustomerDataCreated;
import com.company.transfer.rest.dto.ExternalTransferCreatedDTO;
import com.company.transfer.rest.dto.ExternalTransferDTO;
import com.company.transfer.service.TransferService;
import com.company.transfer.service.model.entities.ExternalTransfer;
import com.company.transfer.utilities.exceptions.TransferBadRequestException;
import com.company.transfer.utilities.exceptions.TransferException;
import com.company.transfer.utilities.exceptions.TransferForbiddenException;
import com.company.transfer.utilities.exceptions.TransferLockedException;
import com.company.transfer.utilities.exceptions.TransferResourceNotFoundException;

import io.eventuate.tram.events.publisher.DomainEventPublisher;

/**
 * The Class TransferServiceImpl.
 */
@Service
public class TransferServiceImpl extends AbstractService implements TransferService {

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(TransferServiceImpl.class);
	
	/** The domain event publisher. */
	@Autowired
	private DomainEventPublisher domainEventPublisher;
	
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
	@Override
	public ExternalTransferCreatedDTO createExternalTransfer(Long accountId, ExternalTransferDTO externalTransferDTO)
			throws TransferResourceNotFoundException, TransferException, TransferBadRequestException,
			TransferLockedException, NumberFormatException, TransferForbiddenException {

		ExternalTransfer transfer = externalTransferDTO.toExternalTransfer();
		transfer.setDestinationAccountId(externalTransferDTO.getDestinationAccountId());		
		transfer = saveExternalTransfer(transfer);
        

        TransferCustomerDataCreated transferCustomerDataCreated = new TransferCustomerDataCreated(
            externalTransferDTO.getDestinationAccountId(),
            externalTransferDTO.getAmount(),
            externalTransferDTO.getDescription()
        );

		domainEventPublisher.publish(
            ExternalTransfer.class,
            accountId,
            Arrays.asList(transferCustomerDataCreated)
            );
        logger.info("TransferData publish successfully");

		return ExternalTransferCreatedDTO.fromExternalTransfer(transfer);			
	}
	
}