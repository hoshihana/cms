package team.cms.service;

import team.cms.entity.Admin;

import java.util.List;

public interface AdminService {

    Admin getAdminByAccountId(int accountId);

    void modifyAdmin(Admin admin);

    List<Admin> getAllAdmin();
}
