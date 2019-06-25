package com.dmarchante.kiddoh.repositories;

import com.dmarchante.kiddoh.models.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Transaction findById(long id);
}
