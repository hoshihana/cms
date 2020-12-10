package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team.cms.entity.User;

@Mapper
@Repository
public interface UserRepository {

    void addUser(User user);

    User getUserByAccountId(Integer accountId);

    void modifyUser(User user);

    User getUserById(Integer id);

    User getUserByUsername(String username);
}
