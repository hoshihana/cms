package team.cms.service;

import team.cms.entity.Conference;

import java.util.List;

public interface ConferenceService {

    List<Conference> getOngoingAndCreatedConference(Integer accountId);

    List<Conference> getOngoingAndParticipatedConference(Integer accountId);

    List<Conference> getEndedAndCreatedConference(Integer accountId);

    List<Conference> getEndedAndParticipatedConference(Integer accountId);

    boolean checkOwnerById(Integer accountId, Integer id);

    boolean checkOwnerByNumber(Integer accountId, String number);

    boolean checkParticipantById(Integer accountId, Integer id);

    boolean checkParticipantByNumber(Integer accountId, String number);

    void addConference(Integer accountId, Conference conference);

    Conference getConferenceById(Integer id);

    Conference getConferenceByNumber(String number);
}
