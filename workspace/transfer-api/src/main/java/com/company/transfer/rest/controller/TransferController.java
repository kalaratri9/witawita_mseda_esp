package com.company.transfer.rest.controller;

import static com.company.transfer.utilities.constants.TransferConstants.X_USER_TOTP;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.company.transfer.rest.dto.DataValidation;
import com.company.transfer.rest.dto.ExternalTransferCreatedDTO;
import com.company.transfer.rest.dto.ExternalTransferDTO;
import com.company.transfer.service.TransferService;
import com.company.transfer.utilities.exceptions.Errors;
import com.company.transfer.utilities.exceptions.TransferBadRequestException;
import com.company.transfer.utilities.exceptions.TransferException;
import com.company.transfer.utilities.exceptions.TransferForbiddenException;
import com.company.transfer.utilities.exceptions.TransferLockedException;
import com.company.transfer.utilities.exceptions.TransferResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class TransferController.
 */
@RestController
@RequestMapping(value = "/accounts")
@Api(value = "TransferController", tags = { "TransferController" })
public class  TransferController {	

	/** The transfer service. */
	@Autowired
	private TransferService transferService;	
	
	/**
	 * Creates the external transfer.
	 *
	 * @param accountId the account id
	 * @param externalTransferDTO the external transfer DTO
	 * @param xUserTotp the x user totp
	 * @param bindingResult the binding result
	 * @param builder the builder
	 * @return the response entity
	 * @throws TransferBadRequestException the transfer bad request exception
	 * @throws TransferResourceNotFoundException the transfer resource not found exception
	 * @throws TransferException the transfer exception
	 * @throws TransferLockedException the transfer locked exception
	 * @throws NumberFormatException the number format exception
	 * @throws TransferForbiddenException the transfer forbidden exception
	 */
	@ApiOperation(value = "Create an external transfer", tags = { "TransferController" })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "External transfer created", response = ExternalTransferCreatedDTO.class),
			@ApiResponse(code = 400, message = "BAD_REQUEST"),
			@ApiResponse(code = 404, message = "NOT FOUND"),
			@ApiResponse(code = 500, message = "INTERNAL SERVER ERROR") })
	@PostMapping(path = "/{accountId}/external-transfers", produces = { MediaType.APPLICATION_JSON }, consumes = {
			MediaType.APPLICATION_JSON })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ExternalTransferCreatedDTO> createExternalTransfer(
			@ApiParam(value = "Account Id", required = true, example = "1001") @PathVariable Long accountId,
			@ApiParam(value = "Destination account to create", required = true) @RequestBody @Valid ExternalTransferDTO externalTransferDTO,
			@RequestHeader(X_USER_TOTP) String xUserTotp, BindingResult bindingResult, UriComponentsBuilder builder)
			throws TransferBadRequestException, TransferResourceNotFoundException, TransferException,
			TransferLockedException, NumberFormatException, TransferForbiddenException {
		if (bindingResult.hasErrors())
			validateErrors(bindingResult, DataValidation.EXTERNAL_TRANSFER_DTO);
		ExternalTransferCreatedDTO output = transferService.createExternalTransfer(accountId, externalTransferDTO);
		return new ResponseEntity<>(output, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	/**
	 * Validate errors.
	 *
	 * @param result the result
	 * @param dto the dto
	 * @throws TransferBadRequestException the transfer bad request exception
	 */
	public void validateErrors(BindingResult result, DataValidation dto) throws TransferBadRequestException {
		String errors = "";
		String comma = "";
		String missingData = null;
		Double errorCode = null;

		for (FieldError error : result.getFieldErrors()) {
			errors += comma + error.getDefaultMessage();
			comma = ", ";
		}

		if (dto.equals(DataValidation.EXTERNAL_TRANSFER_DTO)) {
			missingData = String.format(Errors.INVALID_EXTERNAL_TRANSFER_DTO.getMessage(), errors);
			errorCode = Errors.INVALID_EXTERNAL_TRANSFER_DTO.getCode();
		} else if (dto.equals(DataValidation.INTERNAL_TRANSFER_DTO)) {
			missingData = String.format(Errors.INVALID_INTERNAL_TRANSFER_DTO.getMessage(), errors);
			errorCode = Errors.INVALID_INTERNAL_TRANSFER_DTO.getCode();
		} else if (dto.equals(DataValidation.INTERNAL_TRANSFER_SAME_OWNER_DTO)) {
			missingData = String.format(Errors.INVALID_INTERNAL_TRANSFER_SAME_OWNER_DTO.getMessage(), errors);
			errorCode = Errors.INVALID_INTERNAL_TRANSFER_SAME_OWNER_DTO.getCode();
		} else if (dto.equals(DataValidation.ACCOUNT_DATA_DTO)) {
			missingData = String.format(Errors.INVALID_ACCOUNT_DATA_DTO.getMessage(), errors);
			errorCode = Errors.INVALID_ACCOUNT_DATA_DTO.getCode();
		} else if (dto.equals(DataValidation.INVESTMENT_DTO)) {
			missingData = String.format(Errors.INVALID_INVESTMENT_DTO.getMessage(), errors);
			errorCode = Errors.INVALID_INVESTMENT_DTO.getCode();
		}
		throw new TransferBadRequestException(errorCode, missingData);
	}
}