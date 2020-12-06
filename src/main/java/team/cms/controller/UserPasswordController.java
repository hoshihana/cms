package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.service.PasswordService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user/password")
public class UserPasswordController {

    @Resource
    PasswordService passwordService;

    @PostMapping("/check")
    Boolean passwordCheck(HttpServletRequest request,String inputPassword)
    {
        Integer accountId=(Integer)request.getAttribute("accountId");
        String password=passwordService.getPasswordByAccountId(accountId);
        if(!inputPassword.equals(password))return false;
        return true;
    }

    @PostMapping("/modify")
    Boolean updatePassword(HttpServletRequest request,String newPassword)
    {
        Integer accountId=(Integer)request.getAttribute("accountId");
        passwordService.PasswordModify(newPassword,accountId);
        return true;
    }
}
