package ru.tkachenko.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.tkachenko.account.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
