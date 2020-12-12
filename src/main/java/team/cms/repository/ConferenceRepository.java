package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.cms.entity.Conference;

import java.util.Date;

@Mapper
@Repository
public interface ConferenceRepository {

    void updateProgress(Date currentTime);

    Conference getOngoingAndCreatedConferenceByUserId(Integer userId);

    Conference getOngoingAndParticipatedConferenceByUserId(Integer userId);

    Conference getEndedAndCreatedConferenceByAccountUserId(Integer userId);

    Conference getEndedAndParticipatedConferenceByUserId(Integer userId);

    Conference getCreatedConferenceByUserIdAndId(@Param("userId") Integer userId, @Param("id")Integer id);

    Conference getCreatedConferenceByUserIdAndNumber(@Param("userId") Integer userId, @Param("number")String number);

    Conference getParticipatedConferenceByUserIdAndId(@Param("userId") Integer userId, @Param("id")Integer id);

    Conference getParticipatedCreateConferenceByUserIdAndNumber(@Param("userId") Integer userId, @Param("number")String number);

    Conference getConferenceById(Integer id);

    Conference getConferenceByNumber(String number);

    Conference addConference(Conference conference);

    Conference updateNumber(Integer id);
}
