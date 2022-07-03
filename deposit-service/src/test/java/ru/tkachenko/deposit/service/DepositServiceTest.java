package ru.tkachenko.deposit.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import ru.tkachenko.deposit.controller.dto.DepositResponseDTO;
import ru.tkachenko.deposit.exception.DepositServiceException;
import ru.tkachenko.deposit.repository.DepositRepository;
import ru.tkachenko.deposit.rest.AccountResponseDTO;
import ru.tkachenko.deposit.rest.AccountServiceClient;
import ru.tkachenko.deposit.rest.BillResponseDTO;
import ru.tkachenko.deposit.rest.BillServiceClient;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class DepositServiceTest {

    @Mock
    private DepositRepository depositRepository;

    @Mock
    private AccountServiceClient accountServiceClient;

    @Mock
    private BillServiceClient billServiceClient;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private DepositService depositService;

    @Test
    public void depositServiceTest_withBillId() {
        BillResponseDTO billResponseDTO = createBillResponseDTO();
        Mockito.when(billServiceClient.getBillById(ArgumentMatchers.anyLong()))
                .thenReturn(billResponseDTO);
        Mockito.when(accountServiceClient.getAccountById(ArgumentMatchers.anyLong()))
                .thenReturn(createAccountResponseDTO());
        DepositResponseDTO deposit = depositService.deposit(null, 1L, BigDecimal.valueOf(1000));

        Assertions.assertThat(deposit.getMail()).isEqualTo("lori@cat.xyz");
    }

    @Test(expected = DepositServiceException.class)
    public void depositServiceTest_exception() {
        depositService.deposit(null, null, BigDecimal.valueOf(100));
    }

    private AccountResponseDTO createAccountResponseDTO() {
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        accountResponseDTO.setAccountId(1L);
        accountResponseDTO.setBills(Arrays.asList(1L, 2L, 3L));
        accountResponseDTO.setCreationDate(OffsetDateTime.now());
        accountResponseDTO.setEmail("lori@cat.xyz");
        accountResponseDTO.setName("Lori");
        accountResponseDTO.setPhone("+1349831");
        return accountResponseDTO;
    }

    private BillResponseDTO createBillResponseDTO() {
        BillResponseDTO billResponseDTO = new BillResponseDTO();
        billResponseDTO.setAccountId(1L);
        billResponseDTO.setAmount(BigDecimal.valueOf(1000));
        billResponseDTO.setBillId(1L);
        billResponseDTO.setCreationDate(OffsetDateTime.now());
        billResponseDTO.setIsDefault(true);
        billResponseDTO.setOverdraftEnabled(true);
        return billResponseDTO;
    }
}
