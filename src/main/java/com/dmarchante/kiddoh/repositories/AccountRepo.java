package com.dmarchante.kiddoh.repositories;

import com.dmarchante.kiddoh.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account,Long> {

}
