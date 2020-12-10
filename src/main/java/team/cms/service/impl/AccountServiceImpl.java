package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Account;
import team.cms.repository.AccountRepository;
import team.cms.service.AccountService;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountRepository accountRepository;

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.getAccountByUsername(username);
    }

    @Override
    public boolean usernameAvailable(String username) {
        Account account = accountRepository.getAccountByUsername(username);
        return account == null;
    }

    @Override
    public void addAccount(Account account) {
        accountRepository.addAccount(account);
    }

    @Override
    public boolean checkPassword(Integer id, String password) {
        Account account = accountRepository.getAccountById(id);
        return password.equals(account.getPassword());
    }

    @Override
    public void modifyPassword(Account account) {
        accountRepository.modifyPassword(account);
    }
}
