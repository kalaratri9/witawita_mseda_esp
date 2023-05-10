package com.company.commons.domain.events.transfer;

public class BaseTransferCustomerData {

    private Long destinationAccountId;
    private Double amount;
    private String description;

    public BaseTransferCustomerData() {
        super();
    }

    public BaseTransferCustomerData(Long destinationAccountId, Double amount, String description) {
        super();
        this.destinationAccountId = destinationAccountId;
        this.amount = amount;
        this.description = description;
    }

    public void setDestinationAccountId(Long destinationAccountId){
        this.destinationAccountId = destinationAccountId;
    }

    public Long getDestinationAccountId(){
        return destinationAccountId;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public Double getAmount(){
        return amount;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
    
}
