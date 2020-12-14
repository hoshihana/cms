package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.cms.entity.Conference;
import team.cms.entity.DriverReservation;
import team.cms.service.ConferenceService;
import team.cms.entity.Enrollment;
import team.cms.entity.User;
import team.cms.result.CountResult;
import team.cms.result.Result;
import team.cms.service.DriverReservationService;
import team.cms.service.EnrollmentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/conference")
public class ConferenceController {

    @Resource
    ConferenceService conferenceService;

    @Resource
    EnrollmentService enrollmentService;

    @Resource
    DriverReservationService driverReservationService;

    @PostMapping("/getById")
    Conference getConferenceById(Integer id) {
        return conferenceService.getConferenceById(id);
    }

    @PostMapping("/getByNumber")
    Conference getConferenceByNumber(String number) {
        return conferenceService.getConferenceByNumber(number);

    }
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

        boolean flag = enrollmentService.deleteEnrollment(id, userId);
        if (flag)
            return new Result(true, null);
        else
            return new Result(false, "删除失败！");
    }

    @PostMapping("/chooseFleet")
    Result chooseFleet(Integer id, Integer fleetId) {
        conferenceService.modifyFleetId(id, fleetId);
        return new Result(true, null);
    }

    @PostMapping("/driverReservation/get")
    DriverReservation getDriverReservationByConferenceIdAndUserId(Integer id, Integer userId) {
        return driverReservationService.getDirverReservationByConferenceIdAndUserId(id, userId);
    }

    @PostMapping("/driverReservation")
    DriverReservation getDriverReservationByConferenceId(HttpServletRequest request,Integer id){
        Integer accountId=(Integer)request.getAttribute("account_Id");
        return driverReservationService.getDirverReservationByConferenceId(id,accountId);
    }

    @PostMapping("/check")
    Result checkDriverReservation(HttpServletRequest request,Integer id){
        Integer accountId = (Integer)request.getAttribute("accountId");
        driverReservationService.setDriverReservationUserCheck(id,accountId);
        return new Result(true,null);
    }
}

