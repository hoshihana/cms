package team.cms.service;

import team.cms.entity.Admin;

public interface AdminService {

    Admin getAdminByAccountId(int accountId);

    void modifyAdmin(Admin admin);
}
