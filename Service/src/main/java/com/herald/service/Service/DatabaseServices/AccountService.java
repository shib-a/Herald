package com.herald.service.Service.DatabaseServices;

import com.herald.service.Service.DTOs.AccountDto;
import com.herald.service.Service.DTOs.AccountMapper;
import com.herald.service.Service.Entities.Account;
import com.herald.service.Service.Repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper){
        this.accountRepository=accountRepository;
        this.accountMapper=accountMapper;
    }
    @Transactional
    public AccountDto addAccount(AccountDto accountDto){
        Account save = accountRepository.save(accountMapper.toAccount(accountDto));
        return accountMapper.toAccountDto(save);
    }
    @Transactional
    public AccountDto getAccountById(Long id){
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()){
            var t = new AccountDto();
            t.setId(null);
            return t;
        }
        return accountMapper.toAccountDto(account.get());
    }
}
