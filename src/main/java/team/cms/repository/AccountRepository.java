package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team.cms.entity.Account;

@Mapper
@Repository
public interface AccountRepository {

    Account getAccountByUsername(String name);

    Account getAccountById(Integer id);

    Account getAccountByUserId(Integer userId);

    void addAccount(Account account);

    void modifyPassword(Account account);
}
