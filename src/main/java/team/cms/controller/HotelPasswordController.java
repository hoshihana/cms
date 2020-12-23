package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.result.Result;
import team.cms.service.AccountService;
import team.cms.util.CipherUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/hotel/password")
public class HotelPasswordController {
    @Resource
    private AccountService accountService;

    @PostMapping("/modify")
    public Result updatePassword(HttpServletRequest request, String oldPassword, String newPassword) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        if(!accountService.checkPassword(accountId, CipherUtil.encipherText(oldPassword))) {
            return new Result(false, "旧密码错误");
        } else {
            Account account = new Account();
            account.setId(accountId);
            account.setPassword(CipherUtil.encipherText(newPassword));
            accountService.modifyPassword(account);
            return new Result(true, null);
        }
    }
}
