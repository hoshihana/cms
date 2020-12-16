package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.cms.entity.*;
import team.cms.service.ConferenceService;
import team.cms.result.CheckResult;
import team.cms.result.CountResult;
import team.cms.result.Result;
import team.cms.service.DriverReservationService;
import team.cms.service.EnrollmentService;
import team.cms.service.HotelReservationService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/conference")
public class ConferenceController {

    @Resource
    private ConferenceService conferenceService;

    @Resource
    private EnrollmentService enrollmentService;

    @Resource
    private HotelReservationService hotelReservationService;

    @Resource
    private DriverReservationService driverReservationService;

    @PostMapping("/getById")
    public Conference getConferenceById(Integer id) {
        return conferenceService.getConferenceById(id);
    }

    @PostMapping("/getByNumber")
    public Conference getConferenceByNumber(String number) {
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
    public Result removeEnrollment(Integer id, Integer userId) {
        boolean flag = enrollmentService.removeEnrollment(id, userId);
        if (flag)
            return new Result(true, null);
        else
            return new Result(false, "删除失败！");
    }

    @PostMapping("/chooseFleet")
    public Result chooseFleet(Integer id, Integer fleetId) {
        conferenceService.modifyFleetId(id, fleetId);
        return new Result(true, null);
    }

    @PostMapping("/driverReservation/get")
    public DriverReservation getDriverReservationByConferenceIdAndUserId(Integer id, Integer userId) {
        return driverReservationService.getDirverReservationByConferenceIdAndUserId(id, userId);
    }

    @PostMapping("/driverReservation")
    public DriverReservation getDriverReservationByConferenceId(HttpServletRequest request,Integer id){
        Integer accountId=(Integer)request.getAttribute("accountId");
        return driverReservationService.getDirverReservationByConferenceId(id,accountId);
    }

    @PostMapping("/driverReservation/check")
    public Result checkDriverReservation(HttpServletRequest request,Integer id){
        Integer accountId = (Integer)request.getAttribute("accountId");
        driverReservationService.setDriverReservationUserCheck(id,accountId);
        return new Result(true,null);
    }

    @PostMapping("/driverReservation/checkAll")
    public Boolean checkAllReservationIsChecked(Integer id) {
        return driverReservationService.allDriverReservationChecked(id);
    }


    @PostMapping("/chooseHotel")
    public Result chooseHotel(Integer id, Integer hotelId) {
        conferenceService.setConferenceHotel(id, hotelId);
        return new Result(true, null);
    }

    @PostMapping("/hotelReservation")
    public HotelReservation getAllHotelReservations(HttpServletRequest request, Integer id){
        Integer accountId = (Integer) request.getAttribute("accountId");
        return hotelReservationService.getHotelReservationByAccountId(id, accountId);
    }

    @PostMapping("/hotelReservation/get")
    public HotelReservation getHotelReservation(Integer id, Integer userId){
        return hotelReservationService.getHotelReservationByUserId(id, userId);
    }

    @PostMapping("/hotelReservation/checkAll")
    public CheckResult allHotelReservationChecked(Integer id){
        return new CheckResult(hotelReservationService.allHotelReservationChecked(id));
    }

    @PostMapping("/hotelReservation/check")
    public Result checkHotelReservation(HttpServletRequest request, Integer id){
        Integer accountId = (Integer)request.getAttribute("accountId");
        hotelReservationService.setHotelReservationUserCheck(id, accountId);
        return new Result(true, null);
    }

    @PostMapping("/confirm")
    public Result confirmConference(Integer id) {
        Conference conference = conferenceService.getConferenceById(id);
        if(conference.getFleetId() == null && conference.getHotelId() == null) {
            return new Result(false, "未选择预约车队和酒店");
        } else if(conference.getFleetId() == null) {
            return new Result(false, "未选择预约车队");
        } else if(conference.getHotelId() == null) {
            return new Result(false, "未选择预约酒店");
        } else {
            conferenceService.confirmConference(id);
            return new Result(true, null);
        }
    }
}
