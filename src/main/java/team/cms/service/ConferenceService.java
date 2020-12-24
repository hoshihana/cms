package team.cms.service;

import org.apache.ibatis.annotations.Param;
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

    boolean checkEnrollmentOngoing(String number);

    void addConference(Integer accountId, Conference conference);

    Conference getConferenceById(Integer id);

    Conference getConferenceByNumber(String number);

    void modifyFleetId(Integer id, Integer fleetId);

    boolean checkInviteCode(Integer id, String inviteCode);

    boolean setConferenceHotel(Integer id, Integer hotelId);

    void confirmConference(Integer id);

    void terminateEnrollment(Conference conference);

    Integer countConference();

    List<Conference> getAllOngoingConference();

    void removeConference(Integer id);

    void modifyConference(Conference conference);
}
