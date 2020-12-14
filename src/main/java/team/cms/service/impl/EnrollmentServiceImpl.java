package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Enrollment;
import team.cms.entity.User;
import team.cms.repository.EnrollmentRepository;
import team.cms.repository.UserRepository;
import team.cms.result.ParticipateConferenceResult;
import team.cms.service.EnrollmentService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Resource
    UserRepository userRepository;

    @Resource
    EnrollmentRepository enrollmentRepository;

    @Override
    public Integer getNumberOfEnrollment(Integer id) {
        return enrollmentRepository.getNumberOfEnrollment(id);

    }

    @Override
    public List<User> getEnrollmentUserInfo(Integer id) {
        return enrollmentRepository.getEnrollmentUserInfo(id);
    }

    @Override
    public Enrollment getEnrollmentInfo(Integer id, Integer userId) {
        return enrollmentRepository.getEnrollmentInfo(id, userId);
    }

    @Override
    public boolean removeEnrollment(Integer id, Integer userId) {
        return enrollmentRepository.removeEnrollment(id, userId);
    }

    @Override
    public boolean participateConference(Integer accountId, Enrollment enrollment) {
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        enrollment.setUserId(userId);
        return enrollmentRepository.addEnrollment(enrollment);
    }
}
