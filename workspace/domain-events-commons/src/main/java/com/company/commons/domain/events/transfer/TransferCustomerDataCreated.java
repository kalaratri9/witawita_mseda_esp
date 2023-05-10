package com.company.commons.domain.events.transfer;

import io.eventuate.tram.events.common.DomainEvent;

public class TransferCustomerDataCreated extends BaseTransferCustomerData implements DomainEvent {
    
    public TransferCustomerDataCreated() {
        super();
    }

    public TransferCustomerDataCreated(Long destinationAccountId, Double amount, String description) {
        super(destinationAccountId, amount, description);
    }
}
