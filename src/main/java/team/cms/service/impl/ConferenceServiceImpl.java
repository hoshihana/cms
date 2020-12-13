package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Conference;
import team.cms.entity.enums.Progress;
import team.cms.repository.ConferenceRepository;
import team.cms.repository.UserRepository;
import team.cms.service.ConferenceService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Resource
    UserRepository userRepository;

    @Resource
    ConferenceRepository conferenceRepository;

    @Override
    public List<Conference> getOngoingAndCreatedConference(Integer accountId) {
        conferenceRepository.updateProgress(new Date());
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        return conferenceRepository.getOngoingAndCreatedConferenceByUserId(userId);
    }

    @Override
    public List<Conference> getOngoingAndParticipatedConference(Integer accountId) {
        conferenceRepository.updateProgress(new Date());
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        return conferenceRepository.getOngoingAndParticipatedConferenceByUserId(userId);
    }

    @Override
    public List<Conference> getEndedAndCreatedConference(Integer accountId) {
        conferenceRepository.updateProgress(new Date());
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        return conferenceRepository.getEndedAndCreatedConferenceByAccountUserId(userId);
    }

    @Override
    public List<Conference> getEndedAndParticipatedConference(Integer accountId) {
        conferenceRepository.updateProgress(new Date());
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        return conferenceRepository.getEndedAndParticipatedConferenceByUserId(userId);
    }

    @Override
    public boolean checkOwnerById(Integer accountId, Integer id) {
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        Conference conference = conferenceRepository.getCreatedConferenceByUserIdAndId(userId, id);
        return conference != null;
    }

    @Override
    public boolean checkOwnerByNumber(Integer accountId, String number) {
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        Conference conference = conferenceRepository.getCreatedConferenceByUserIdAndNumber(userId, number);
        return conference != null;
    }

    @Override
    public boolean checkParticipantById(Integer accountId, Integer id) {
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        Conference conference = conferenceRepository.getParticipatedConferenceByUserIdAndId(userId, id);
        return conference != null;
    }

    @Override
    public boolean checkParticipantByNumber(Integer accountId, String number) {
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        Conference conference = conferenceRepository.getParticipatedConferenceByUserIdAndNumber(userId, number);
        return conference != null;
    }

    @Override
    public void addConference(Integer accountId, Conference conference) {
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        conference.setCreateTime(new Date());
        conference.setUserId(userId);
        conference.setProgress(Progress.ENROLLMENT);
        conferenceRepository.addConference(conference);
        conferenceRepository.updateNumber(conference.getId());
    }

    @Override
    public Conference getConferenceById(Integer id) {
        conferenceRepository.updateProgress(new Date());
        return conferenceRepository.getConferenceById(id);
    }

    @Override
    public Conference getConferenceByNumber(String number) {
        conferenceRepository.updateProgress(new Date());
        return conferenceRepository.getConferenceByNumber(number);
    }
}
