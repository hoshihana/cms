package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.repository.PasswordRepository;
import team.cms.service.PasswordService;

import javax.annotation.Resource;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Resource
    PasswordRepository passwordRepository;

    @Override
    public String getPasswordByAccountId(int accountId) {
        return passwordRepository.getPasswordByAccountId(accountId);
    }

    @Override
    public void PasswordModify(String password, int accountId) {
        passwordRepository.updatePasswordByAccountId(password,accountId);
    }
}
