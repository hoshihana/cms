package team.cms.service;

import team.cms.entity.Account;


public interface AccountService {

    Account getAccountByUsername(String username);

    boolean usernameAvailable(String username);

    void addAccount(Account account);

    boolean checkPassword(Integer id, String password);

    void modifyPassword(Account account);

    Account getAccountByUserId(Integer userId);
}
