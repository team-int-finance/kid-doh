package com.dmarchante.kiddoh.repositories;

import com.dmarchante.kiddoh.models.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}
