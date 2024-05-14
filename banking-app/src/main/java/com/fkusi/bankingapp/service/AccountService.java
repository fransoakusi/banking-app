package com.fkusi.bankingapp.service;

import com.fkusi.bankingapp.dto.AccountDto;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);
    
    AccountDto deposit(Long id, double amount);
    

}
