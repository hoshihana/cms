package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Enrollment;
import team.cms.entity.User;
import team.cms.repository.EnrollmentRepository;
import team.cms.repository.UserRepository;
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
    public List<User> getAllParticipant(Integer id) {
        return enrollmentRepository.getAllParticipant(id);
    }

    @Override
    public Enrollment getEnrollmentByUserId(Integer id, Integer userId) {
        return enrollmentRepository.getEnrollment(id, userId);
    }

    @Override
    public Enrollment getEnrollmentByAccountId(Integer id, Integer accountId) {
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        return enrollmentRepository.getEnrollment(id, userId);
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
