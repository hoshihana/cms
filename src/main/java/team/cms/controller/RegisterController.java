package team.cms.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.entity.User;
import team.cms.entity.enums.Gender;
import team.cms.entity.enums.Role;
import team.cms.service.AccountService;
import team.cms.service.UserService;

import javax.annotation.Resource;
import java.sql.Date;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Resource
    AccountService accountService;

    @Resource
    UserService userService;

    @RequestMapping("/checkUsername")
    boolean checkUsername(String username) {
        return accountService.usernameAvailable(username);
    }

    @PostMapping("/submit")
    boolean register(String username, String password, String name, Gender gender, Date birthday, String residentIdNumber, String telephone, String email, String workplace) {

        if(!accountService.usernameAvailable(username)) {
            return false;
        }
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole(Role.USER);

        accountService.addAccount(account);

        User user = new User();
        user.setAccountId(account.getId());
        user.setName(name);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setResidentIdNumber(residentIdNumber);
        user.setTelephone(telephone);
        user.setEmail(email);
        user.setWorkplace(workplace);

        userService.addUser(user);

        return true;
    }
}
