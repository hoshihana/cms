package team.cms.service;

public interface PasswordService {

    String getPasswordByAccountId(int account_Id);

    void PasswordModify(String password,int accountId);

}
