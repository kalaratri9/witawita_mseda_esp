package com.company.transfer.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.transfer.service.model.entities.ExternalTransfer;

/**
 * The Interface ExternalTransferRepository.
 */
@Repository
public interface ExternalTransferRepository extends JpaRepository<ExternalTransfer, Long> {

	/**
	 * Find by external transfer id and withdrawal account id.
	 *
	 * @param externalTransferId  the external transfer id
	 * @param withdrawalAccountId the withdrawal account id
	 * @return the external transfer
	 */
	ExternalTransfer findByExternalTransferIdAndWithdrawalAccountId(Long externalTransferId, Long withdrawalAccountId);

	/**
	 * Find by time window.
	 *
	 * @param withdrawalAccountId the withdrawal account id
	 * @param timeWindow the time window
	 * @return the list
	 */
	@Query(value = "SELECT * FROM transfer.external_transfer WHERE transfer_status = 'OK' "
			+ "AND creation_datetime > (utc_timestamp() - interval :timeWindow SECOND) "
			+ "AND withdrawal_account_id = :withdrawalAccountId ", nativeQuery = true)
	List<ExternalTransfer> findByTimeWindow(@Param("withdrawalAccountId") Long withdrawalAccountId,
			@Param("timeWindow") Integer timeWindow);

	/**
	 * Count by day.
	 *
	 * @param withdrawalAccountId the withdrawal account id
	 * @return the integer
	 */
	@Query(value = "SELECT count(*) as count FROM transfer.external_transfer WHERE transfer_status = 'OK' "
			+ "AND DATE(CONVERT_TZ(creation_datetime,'UTC','America/Mexico_City')) = DATE(CONVERT_TZ(utc_timestamp(),'UTC','America/Mexico_City')) "
			+ "AND withdrawal_account_id = :withdrawalAccountId ", nativeQuery = true)
	Integer countByDay(@Param("withdrawalAccountId") Long withdrawalAccountId);

}
