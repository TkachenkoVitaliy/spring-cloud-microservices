package ru.tkachenko.deposit.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tkachenko.deposit.entity.Deposit;

public interface DepositRepository extends CrudRepository <Deposit, Long> {
}
