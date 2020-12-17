package team.cms.service;

import team.cms.entity.Enrollment;
import team.cms.entity.User;
import team.cms.result.ParticipateConferenceResult;

import java.util.List;

public interface EnrollmentService {

    Integer getNumberOfEnrollment(Integer id);

    List<User> getAllParticipant(Integer id);

    Enrollment getEnrollmentByUserId(Integer id, Integer userId);

    Enrollment getEnrollmentByAccountId(Integer id, Integer accountId);

    boolean removeEnrollment(Integer id, Integer userId);

    boolean  participateConference(Integer accountId, Enrollment enrollment);

}
