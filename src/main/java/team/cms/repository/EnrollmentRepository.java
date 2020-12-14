package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team.cms.entity.Enrollment;
import team.cms.entity.User;

import java.util.List;

@Mapper
@Repository
public interface EnrollmentRepository {
    Integer getNumberOfEnrollment(Integer id);

    List<User> getEnrollmentUserInfo(Integer id);

    Enrollment getEnrollmentInfo(Integer id, Integer userId);

    boolean deleteEnrollment(Integer id, Integer userId);
}