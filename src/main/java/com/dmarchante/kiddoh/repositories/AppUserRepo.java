package com.dmarchante.kiddoh.repositories;

import com.dmarchante.kiddoh.models.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
