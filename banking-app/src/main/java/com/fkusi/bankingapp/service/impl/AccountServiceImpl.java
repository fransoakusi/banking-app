package com.fkusi.bankingapp.service.impl;

import javax.management.RuntimeErrorException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.fkusi.bankingapp.dto.AccountDto;
import com.fkusi.bankingapp.entity.Account;
import com.fkusi.bankingapp.mapper.AccountMapper;
import com.fkusi.bankingapp.respository.AccountRespository;
import com.fkusi.bankingapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
    
    @Override
    public AccountDto getAccountById(@PathVariable Long id) {
        // TODO Auto-generated method stub
  Account account =  accountRespository
  .findById(id)
  .orElseThrow(() -> new RuntimeErrorException(null, "Account does not exist"));
  return AccountMapper.mapToAccountDto(account);
    }



    private AccountRespository accountRespository;
    


    public AccountServiceImpl(AccountRespository accountRespository) {
        this.accountRespository = accountRespository;
    }



    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        // TODO Auto-generated method stub

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRespository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }



    @Override
    public AccountDto deposit(Long id, double amount) {
        // TODO Auto-generated method stub
        Account account =  accountRespository
        .findById(id)
        .orElseThrow(() -> new RuntimeErrorException(null, "Account does not exist"));
       
       double total = account.getBalance() + amount;
       account.setBalance(total);
      Account savedAccount =  accountRespository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }
    

}
