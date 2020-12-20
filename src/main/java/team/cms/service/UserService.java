package team.cms.service;

import team.cms.entity.User;

import java.util.List;

public interface UserService {

    User getUserByAccountId(Integer accountId);

    void addUser(User user);

    void modifyUser(User user);

    Integer countUser();

    User getUserById(Integer id);

    User getUserByUsername(String username);

    List<User> getAllUser();

    boolean checkUserRemovable(Integer userId);

    void removeUser(Integer userId);
}
