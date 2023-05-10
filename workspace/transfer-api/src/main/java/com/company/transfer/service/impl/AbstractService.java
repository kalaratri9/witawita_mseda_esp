package com.company.transfer.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.transfer.service.model.entities.ExternalTransfer;
import com.company.transfer.service.repository.ExternalTransferRepository;

/**
 * The Class AbstractService.
 */
public class AbstractService {

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(AbstractService.class);

	/** The external transfer repository. */
	@Autowired
	private ExternalTransferRepository externalTransferRepository;

	/**
	 * Save external transfer.
	 *
	 * @param transfer the transfer
	 * @return the external transfer
	 */
	@Transactional
	protected ExternalTransfer saveExternalTransfer(ExternalTransfer transfer) {
		transfer = externalTransferRepository.save(transfer);
		logger.debug("Saved {}", transfer.toString());
		return transfer;
	}

}
