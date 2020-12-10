package team.cms.service;

import team.cms.entity.User;

public interface UserService {

    User getUserByAccountId(Integer accountId);

    void addUser(User user);

    void modifyUser(User user);

    User getUserById(Integer id);

    User getUserByUsername(String username);
}
