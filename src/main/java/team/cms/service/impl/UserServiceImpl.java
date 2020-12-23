package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Conference;
import team.cms.entity.User;
import team.cms.repository.UserRepository;
import team.cms.service.ConferenceService;
import team.cms.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private ConferenceService conferenceService;

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
    public Integer countUser() {
        return userRepository.countUser();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public boolean checkUserRemovable(Integer userId) {
        Integer accountId = userRepository.getUserById(userId).getAccountId();
        return conferenceService.getOngoingAndParticipatedConference(accountId).isEmpty() && conferenceService.getOngoingAndCreatedConference(accountId).isEmpty();
    }

    @Override
    public void removeUser(Integer userId) {
        userRepository.removeUser(userId);
    }
}
