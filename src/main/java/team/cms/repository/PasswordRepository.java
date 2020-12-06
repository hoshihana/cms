package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PasswordRepository {

    String getPasswordByAccountId(int accountId);

    void  updatePasswordByAccountId(String password,int accountId);
}
