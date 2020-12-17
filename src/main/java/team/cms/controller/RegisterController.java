package team.cms.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.entity.User;
import team.cms.entity.enums.Gender;
import team.cms.entity.enums.Role;
import team.cms.result.CheckResult;
import team.cms.result.Result;
import team.cms.service.AccountService;
import team.cms.service.UserService;
import team.cms.util.DateUtil;
import team.cms.util.EncodeUtil;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Resource
    private AccountService accountService;

    @Resource
    private UserService userService;

    @RequestMapping("/checkUsername")
    public CheckResult checkUsername(String username) {
        return new CheckResult(accountService.usernameAvailable(username));
    }

    @PostMapping("/submit")
    public Result register(String username, String password, String name, Gender gender, String birthday, String residentIdNumber, String telephone, String email, String workplace) {

        if(!accountService.usernameAvailable(username)) {
            return new Result(false, "用户名不可用");
        }
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(EncodeUtil.encodeByMd5(password));
        account.setRole(Role.USER);

        accountService.addAccount(account);

        User user = new User();
        user.setAccountId(account.getId());
        user.setName(name);
        user.setGender(gender);
        user.setBirthday(DateUtil.parseDateString(birthday));
        user.setResidentIdNumber(residentIdNumber);
        user.setTelephone(telephone);
        user.setEmail(email);
        user.setWorkplace(workplace);

        userService.addUser(user);

        return new Result(true, null);
    }
}
