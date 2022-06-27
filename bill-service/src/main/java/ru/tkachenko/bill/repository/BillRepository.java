package ru.tkachenko.bill.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tkachenko.bill.entity.Bill;

public interface BillRepository extends CrudRepository<Bill, Long> {
}
