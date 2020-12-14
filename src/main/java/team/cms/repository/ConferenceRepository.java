package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.cms.entity.Conference;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ConferenceRepository {

    void updateProgress(Date currentTime);

    List<Conference> getOngoingAndCreatedConferenceByUserId(Integer userId);

    List<Conference> getOngoingAndParticipatedConferenceByUserId(Integer userId);

    List<Conference> getEndedAndCreatedConferenceByAccountUserId(Integer userId);

    List<Conference> getEndedAndParticipatedConferenceByUserId(Integer userId);

    Conference getCreatedConferenceByUserIdAndId(@Param("userId") Integer userId, @Param("id")Integer id);

    Conference getCreatedConferenceByUserIdAndNumber(@Param("userId") Integer userId, @Param("number")String number);

    Conference getParticipatedConferenceByUserIdAndId(@Param("userId") Integer userId, @Param("id")Integer id);

    Conference getParticipatedConferenceByUserIdAndNumber(@Param("userId") Integer userId, @Param("number")String number);

    Conference getConferenceById(Integer id);

    Conference getConferenceByNumber(String number);

    void addConference(Conference conference);

    void updateNumber(Integer id);

    boolean updateConferenceHotel(@Param("id")Integer id, @Param("hotelId")Integer hotelId);
}
