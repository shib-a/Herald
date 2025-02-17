package com.herald.service.Service.DTOs.mappers;

import com.herald.service.Service.DTOs.AccountDto;
import com.herald.service.Service.Entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {
    AccountDto toAccountDto(Account account);
    Account toAccount(AccountDto accountDto);
    List<AccountDto> toAccountDtoList(List<Account> accountList);

}
