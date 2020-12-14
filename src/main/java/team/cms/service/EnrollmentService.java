package team.cms.service;

import team.cms.entity.Enrollment;
import team.cms.entity.User;
import team.cms.result.ParticipateConferenceResult;

import java.util.List;

public interface EnrollmentService {

    Integer getNumberOfEnrollment(Integer id);

    List<User> getEnrollmentUserInfo(Integer id);

    Enrollment getEnrollmentInfo(Integer id, Integer userId);

    boolean removeEnrollment(Integer id, Integer userId);

    boolean  participateConference(Integer accountId, Enrollment enrollment);

}
