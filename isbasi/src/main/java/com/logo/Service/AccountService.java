package com.logo.Service;

import com.logo.Model.Account;
import com.logo.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Account accountRequest) {
        return accountRepository.save(accountRequest);
    }

    public List<Account> getAllAcounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(int id) {
        return accountRepository.findById(id).orElseThrow();
    }

    public Account updateAccount(int id, Account accountRequest) {
        Account foundAccount = accountRepository.findById(id).orElseThrow();

        foundAccount.setAccountName(accountRequest.getAccountName());
        foundAccount.setAccountNumber(accountRequest.getAccountNumber());
        foundAccount.setCurrencyType(accountRequest.getCurrencyType());
        foundAccount.setIban(accountRequest.getIban());
        foundAccount.setBalance(accountRequest.getBalance());

        return accountRepository.save(foundAccount);
    }

    public String deleteAccount(int id) {
        accountRepository.deleteById(id);

        return id + " id'li account silindi.";
    }
}
