package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.cms.entity.Enrollment;
import team.cms.entity.User;
import team.cms.result.ParticipateConferenceResult;

import java.util.List;

@Mapper
@Repository
public interface EnrollmentRepository {
    Integer getNumberOfEnrollment(Integer id);

    List<User> getEnrollmentUserInfo(Integer id);

    Enrollment getEnrollmentInfo(@Param("id")Integer id, @Param("userId")Integer userId);

    boolean removeEnrollment(@Param("id")Integer id, @Param("userId")Integer userId);

    boolean addEnrollment(Enrollment enrollment);
}
