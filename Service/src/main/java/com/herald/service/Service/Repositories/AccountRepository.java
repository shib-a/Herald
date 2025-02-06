package com.herald.service.Service.Repositories;

import com.herald.service.Service.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
