package com.fkusi.bankingapp.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fkusi.bankingapp.dto.AccountDto;
import com.fkusi.bankingapp.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountServcie;

    public AccountController(AccountService accountServcie) {
        this.accountServcie = accountServcie;
    }

    //Add Account REST API 
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
   return new ResponseEntity<>(accountServcie.createAccount(accountDto), HttpStatus.CREATED);


    }
   @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){

        AccountDto accountDto = accountServcie.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

     @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, 
        Map<String, Double> request ){
      Double amount = request.get("amount");
    
     AccountDto accountDto = accountServcie.deposit(id, amount);
    return ResponseEntity.ok(accountDto);
    }

}
