package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Admin;
import team.cms.result.Result;
import team.cms.service.AdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/admin/profile")
public class AdminProfileController {
    @Resource
    private AdminService adminService;

    @PostMapping("")
    public Admin getAdminProfile(HttpServletRequest request) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return adminService.getAdminByAccountId(accountId);
    }

    @PostMapping("/modify")
    public Result modifyAdminProfile(HttpServletRequest request, String name, String telephone, String email) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        Admin admin = new Admin();
        admin.setAccountId(accountId);
        admin.setName(name);
        admin.setTelephone(telephone);
        admin.setEmail(email);
        adminService.modifyAdmin(admin);
        return new Result(true, null);
    }
}
