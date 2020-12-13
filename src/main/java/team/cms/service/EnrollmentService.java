package team.cms.service;

import team.cms.entity.Enrollment;
import team.cms.entity.User;

import java.util.List;

public interface EnrollmentService {

    Integer getNumberOfEnrollment(Integer id);

    List<User> getEnrollmentUserInfo(Integer id);

    Enrollment getEnrollmentInfo(Integer id, Integer userId);

    boolean deleteEnrollment(Integer id, Integer userId);

}
