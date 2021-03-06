package ru.tkachenko.bill.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.tkachenko.bill.entity.Bill;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
public class BillResponseDTO {

    private Long billId;
    private Long accountId;
    private BigDecimal amount;
    private Boolean isDefault;
    private OffsetDateTime creationDate;
    private Boolean overdraftEnabled;

    public BillResponseDTO(Bill bill) {
        this.billId = bill.getBillId();
        this.accountId = bill.getAccountId();
        this.amount = bill.getAmount();
        this.isDefault = bill.getIsDefault();
        this.creationDate = bill.getCreationDate();
        this.overdraftEnabled = bill.getOverdraftEnabled();
    }
}
