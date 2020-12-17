package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.result.PasswordModifyResult;
import team.cms.service.AccountService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/hotel/password")
public class HotelPasswordController {

    @Resource
    private AccountService accountService;

    @PostMapping("/modify")
    public PasswordModifyResult updatePassword(HttpServletRequest request, String oldPassword, String newPassword)
    {
        Integer accountId = (Integer)request.getAttribute("accountId");
        if(!accountService.checkPassword(accountId, oldPassword)) {
            return new PasswordModifyResult(false, false, "旧密码错误");
        } else {
            Account account = new Account();
            account.setId(accountId);
            account.setPassword(newPassword);
            accountService.modifyPassword(account);
            return new PasswordModifyResult(true, true, null);
        }
    }
}
