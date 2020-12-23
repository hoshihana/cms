package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.User;
import team.cms.entity.enums.Gender;
import team.cms.result.Result;
import team.cms.service.UserService;
import team.cms.util.DateUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user/profile")
public class UserProfileController {

    @Resource
    private UserService userService;

    @RequestMapping("")
    public User getProfile(HttpServletRequest request) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return userService.getUserByAccountId(accountId);
    }

    @PostMapping("/modify")
    public Result modifyProfile(HttpServletRequest request, String name, Gender gender, String birthday, String residentIdNumber, String email, String telephone, String workplace) {
        User user = new User();
        user.setAccountId((Integer)request.getAttribute("accountId"));
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

    @PostMapping("/getById")
    public User getProfileById(Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/getByUsername")
    public User getProfileByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/getByAccountId")
    public User getProfileByAccountId(Integer accountId) {
        return userService.getUserByAccountId(accountId);
    }
}
