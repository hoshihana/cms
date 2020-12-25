package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team.cms.entity.Admin;

import java.util.List;

@Mapper
@Repository
public interface AdminRepository {

    Admin getAdminByAccountId(Integer accountId);

    void modifyAdmin(Admin admin);

    List<Admin> getAllAdmin();
}
