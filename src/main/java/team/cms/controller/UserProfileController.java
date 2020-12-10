package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.User;
import team.cms.entity.enums.Gender;
import team.cms.result.Result;
import team.cms.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/api/user/profile")
public class UserProfileController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    User getProfile(HttpServletRequest request) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return userService.getUserByAccountId(accountId);
    }

    @PostMapping("/modify")
    Result modifyProfile(HttpServletRequest request, String name, Gender gender, Date birthday, String residentIdNumber, String email, String telephone, String workplace) {
        User user = new User();
        user.setAccountId((Integer)request.getAttribute("accountId"));
        user.setName(name);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setResidentIdNumber(residentIdNumber);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setWorkplace(workplace);
        userService.modifyUser(user);
        return new Result(true, null);
    }

    @PostMapping("/getById")
    User getProfileById(Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/getByUsername")
    User getProfileByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/getByAccountId")
    User getProfileByAccountId(Integer accountId) {
        return userService.getUserByAccountId(accountId);
    }
}
