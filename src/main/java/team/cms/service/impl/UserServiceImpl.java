package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.User;
import team.cms.repository.UserRepository;
import team.cms.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public User getUserByAccountId(Integer accountId) {
        return userRepository.getUserByAccountId(accountId);
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void modifyUser(User user) {
        userRepository.modifyUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
