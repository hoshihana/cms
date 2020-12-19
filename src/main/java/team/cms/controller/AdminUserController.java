package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.entity.User;
import team.cms.entity.enums.Gender;
import team.cms.result.BriefUserResult;
import team.cms.result.CountResult;
import team.cms.result.Result;
import team.cms.service.AccountService;
import team.cms.service.UserService;
import team.cms.util.CipherUtil;
import team.cms.util.DateUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/admin/user/")
public class AdminUserController {
    @Resource
    private UserService userService;

    @Resource
    private AccountService accountService;

    @PostMapping("/count")
    public CountResult countUser() {
        return new CountResult(userService.countUser());
    }

    @PostMapping("/getAll")
    public List<BriefUserResult> getAllUser() {
        List<BriefUserResult> briefUserResults = new ArrayList<>();
        List<User> users = userService.getAllUser();
        for(User user : users) {
            Account account = accountService.getAccountById(user.getAccountId());
            briefUserResults.add(new BriefUserResult(account.getId(), account.getUsername(), user.getId(), user.getName()));
        }
        return briefUserResults;
    }

    @PostMapping("/remove")
    public Result removeUser(Integer userId) {
        if(!userService.checkUserRemovable(userId)) {
            return new Result(false, "存在该用户参加的或创建的进行中会议");
        } else {
            Integer accountId = userService.getUserById(userId).getAccountId();
            userService.removeUser(userId);
            accountService.removeAccount(accountId);
            return new Result(true, null);
        }
    }

    @PostMapping("/profile/get")
    public User getUserProfile(Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/profile/modify")
    public Result modifyUserProfile(Integer userId, String name, Gender gender, String birthday, String residentIdNumber, String email, String telephone, String workplace) {
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setGender(gender);
        user.setBirthday(DateUtil.parseDateString(birthday));
        user.setResidentIdNumber(residentIdNumber);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setWorkplace(workplace);
        userService.modifyUser(user);
        return new Result(true, null);
    }

    @PostMapping("/password/modify")
    public Result modifyUserPassword(Integer userId, String password) {
        Integer accountId = userService.getUserById(userId).getAccountId();
        Account account = new Account();
        account.setId(accountId);
        account.setPassword(CipherUtil.encipherText(password));
        accountService.modifyPassword(account);
        return new Result(true, null);
    }
}
