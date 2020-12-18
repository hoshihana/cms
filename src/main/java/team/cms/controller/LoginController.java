package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.entity.enums.Role;
import team.cms.result.LoginResult;
import team.cms.service.*;
import team.cms.util.CipherUtil;
import team.cms.util.JsonWebTokenUtil;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Resource
    private AccountService accountService;

    @PostMapping("/submit")
    public LoginResult loginSubmit(Role role, String username, String password) {

        Account account = accountService.getAccountByUsername(username);

        LoginResult loginResult = new LoginResult();

        if(account == null || !password.equals(CipherUtil.decipherText(account.getPassword())) || account.getRole() != role) {
            loginResult.setSuccess(false);
            loginResult.setMessage("用户名或密码错误");
        } else {
            loginResult.setSuccess(true);
            loginResult.setToken(JsonWebTokenUtil.createJWT(account));
            loginResult.setUsername(account.getUsername());
            loginResult.setAccountId(account.getId());
            loginResult.setRole(role);
        }

        return loginResult;
    }

}
