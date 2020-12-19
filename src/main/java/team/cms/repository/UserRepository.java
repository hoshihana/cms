package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team.cms.entity.User;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {

    void addUser(User user);

    User getUserByAccountId(Integer accountId);

    void modifyUser(User user);

    User getUserById(Integer id);

    User getUserByUsername(String username);

    Integer countUser();

    List<User> getAllUser();

    void removeUser(Integer id);
}
