package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Driver;
import team.cms.entity.Enrollment;
import team.cms.entity.User;
import team.cms.repository.EnrollmentRepository;
import team.cms.result.CountResult;
import team.cms.result.Result;
import team.cms.service.DriverService;
import team.cms.service.EnrollmentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/conference")

public class ConferenceController {
    @Resource
    EnrollmentService enrollmentService;

    @PostMapping("/participant/count")
    public CountResult getNumberOfEnrollment(Integer id) {
        Integer amount=enrollmentService.getNumberOfEnrollment(id);
        return new CountResult(amount);
    }

    @PostMapping("/participant/get")
    public List<User> getEnrollmentUserInfo(Integer id) {
        List<User> users=enrollmentService.getEnrollmentUserInfo(id);
        return users;
    }

    @PostMapping("/enrollment/get")
    public Enrollment getEnrollmentInfo(Integer id, Integer userId) {
        Enrollment enrollment=enrollmentService.getEnrollmentInfo(id, userId);
        return enrollment;
    }

    @PostMapping("/enrollment/remove")
    public Result deleteEnrollment(Integer id, Integer userId) {

        boolean flag=enrollmentService.deleteEnrollment(id, userId);
        if(flag)
            return new Result(true, null);
        else
            return new Result(false, "删除失败！");
    }
}
