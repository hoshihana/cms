package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Admin;
import team.cms.service.AdminService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/getAll")
    public Admin getAllAdmin() {
        return adminService.getAdminByAccountId(1);
    }
}
