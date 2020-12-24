package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Admin;
import team.cms.repository.AdminRepository;
import team.cms.service.AdminService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;

    @Override
    public Admin getAdminByAccountId(int accountId) {
        return adminRepository.getAdminByAccountId(accountId);
    }

    @Override
    public void modifyAdmin(Admin admin) {
        adminRepository.modifyAdmin(admin);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.getAllAdmin();
    }
}
