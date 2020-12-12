package team.cms.service;

import team.cms.entity.Enrollment;
import team.cms.entity.User;

import java.util.List;

public interface EnrollmentService {

    Integer getNumberOfParticipants(Integer id);

    List<User> getParticipantsUserInfo(Integer id);

    Enrollment getEnrollmentInfo(Integer id, Integer userId);

    void deleteParticipant(Integer id, Integer userId);

}
