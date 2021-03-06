package ru.tkachenko.account.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.tkachenko.account.entity.Account;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class AccountResponseDTO {

    private Long accountId;
    private String name;
    private String email;
    private String phone;
    private List<Long> bills;
    private OffsetDateTime creationDate;

    public AccountResponseDTO(Account account) {
        this.accountId = account.getAccountId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.phone = account.getPhone();
        this.bills = account.getBills();
        this.creationDate = account.getCreationDate();
    }
}
