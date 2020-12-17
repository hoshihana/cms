package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.*;
import team.cms.result.DriverReservationResult;
import team.cms.result.Result;
import team.cms.service.DriverReservationService;
import team.cms.service.DriverService;
import team.cms.service.EnrollmentService;
import team.cms.service.UserService;
import team.cms.util.DateUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/driver/reservation")
public class DriverReservationController {

    @Resource
    private DriverReservationService driverReservationService;
    @Resource
    private DriverService driverService;
    @Resource
    private UserService userService;
    @Resource
    private EnrollmentService enrollmentService;

    @PostMapping("/unchecked")
    public List<DriverReservationResult> getUncheckedReservation(HttpServletRequest request) {
        Integer accountId = (Integer) request.getAttribute("accountId");
        List<DriverReservation> driverReservationList = driverReservationService.getUncheckedDriverReservationByFleetId(accountId);
        List<DriverReservationResult> driverReservationResultList = new ArrayList<>();

        for (DriverReservation driverReservation : driverReservationList) {
            Integer userId = driverReservation.getUserId();
            User user = new User();
            user = userService.getUserById(userId);

            Enrollment enrollment = new Enrollment();
            enrollment = enrollmentService.getEnrollmentByUserId(driverReservation.getConferenceId(), user.getId());

            DriverReservationResult driverReservationResult = new DriverReservationResult();
            driverReservationResult.setConferenceId(driverReservation.getConferenceId());
            driverReservationResult.setUserId(user.getId());
            driverReservationResult.setName(user.getName());
            driverReservationResult.setGender(user.getGender());
            driverReservationResult.setTelephone(user.getTelephone());
            driverReservationResult.setArriveTime(enrollment.getArriveTime());
            driverReservationResult.setArriveSite(enrollment.getArriveSite());
            driverReservationResult.setReserveTime(driverReservation.getReserveTime());
            driverReservationResult.setDriverCheck(driverReservation.isDriverCheck());
            driverReservationResult.setDriverId(driverReservation.getDriverId());
            driverReservationResult.setPickupTime(driverReservation.getPickupTime());
            driverReservationResult.setPickupSite(driverReservation.getPickupSite());
            driverReservationResult.setCarNumber(driverReservation.getCarNumber());
            driverReservationResult.setUserCheck(driverReservation.isUserCheck());
            driverReservationResultList.add(driverReservationResult);
        }

        return driverReservationResultList;
    }

    @PostMapping("/checked")
    public List<DriverReservationResult> getCheckedReservation(HttpServletRequest request) {
        Integer accountId = (Integer) request.getAttribute("accountId");


        Driver driver = new Driver();
        driver = driverService.getDriverByAccountId(accountId);

        List<DriverReservation> driverReservationList = driverReservationService.getCheckDriverReservationByDriverId(driver.getId());
        List<DriverReservationResult> driverReservationResultList = new ArrayList<>();


        for (DriverReservation driverReservation : driverReservationList) {
            Integer userId = driverReservation.getUserId();
            User user = new User();
            user = userService.getUserById(userId);

            Enrollment enrollment = new Enrollment();
            enrollment = enrollmentService.getEnrollmentByUserId(driverReservation.getConferenceId(), user.getId());

            DriverReservationResult driverReservationResult = new DriverReservationResult();
            driverReservationResult.setConferenceId(driverReservation.getConferenceId());
            driverReservationResult.setUserId(user.getId());
            driverReservationResult.setName(user.getName());
            driverReservationResult.setGender(user.getGender());
            driverReservationResult.setTelephone(user.getTelephone());
            driverReservationResult.setArriveTime(enrollment.getArriveTime());
            driverReservationResult.setArriveSite(enrollment.getArriveSite());
            driverReservationResult.setReserveTime(driverReservation.getReserveTime());
            driverReservationResult.setDriverCheck(driverReservation.isDriverCheck());
            driverReservationResult.setDriverId(driverReservation.getDriverId());
            driverReservationResult.setPickupTime(driverReservation.getPickupTime());
            driverReservationResult.setPickupSite(driverReservation.getPickupSite());
            driverReservationResult.setCarNumber(driverReservation.getCarNumber());
            driverReservationResult.setUserCheck(driverReservation.isUserCheck());
            driverReservationResultList.add(driverReservationResult);
        }

        return driverReservationResultList;
    }

    @PostMapping("/ended")
    public List<DriverReservationResult> getEndedReservation(HttpServletRequest request) {

        Integer accountId = (Integer) request.getAttribute("accountId");

        Driver driver = new Driver();
        driver = driverService.getDriverByAccountId(accountId);


        List<DriverReservation> driverReservationList = driverReservationService.getEndedDriverReservationByDriverId(driver.getId());
        List<DriverReservationResult> driverReservationResultList = new ArrayList<>();

        for (DriverReservation driverReservation : driverReservationList) {
            Integer userId = driverReservation.getUserId();
            User user = new User();
            user = userService.getUserById(userId);

            Enrollment enrollment = new Enrollment();
            enrollment = enrollmentService.getEnrollmentByUserId(driverReservation.getConferenceId(), user.getId());

            DriverReservationResult driverReservationResult = new DriverReservationResult();
            driverReservationResult.setConferenceId(driverReservation.getConferenceId());
            driverReservationResult.setUserId(user.getId());
            driverReservationResult.setName(user.getName());
            driverReservationResult.setGender(user.getGender());
            driverReservationResult.setTelephone(user.getTelephone());
            driverReservationResult.setArriveTime(enrollment.getArriveTime());
            driverReservationResult.setArriveSite(enrollment.getArriveSite());
            driverReservationResult.setReserveTime(driverReservation.getReserveTime());
            driverReservationResult.setDriverCheck(driverReservation.isDriverCheck());
            driverReservationResult.setDriverId(driverReservation.getDriverId());
            driverReservationResult.setPickupTime(driverReservation.getPickupTime());
            driverReservationResult.setPickupSite(driverReservation.getPickupSite());
            driverReservationResult.setCarNumber(driverReservation.getCarNumber());
            driverReservationResult.setUserCheck(driverReservation.isUserCheck());
            driverReservationResultList.add(driverReservationResult);
        }

        return driverReservationResultList;
    }

    @PostMapping("/check")
    public Result checkReservation(HttpServletRequest request, Integer conferenceId, Integer userId, String pickupTime, String pickupSite, String carNumber) {
        Integer accountId = (Integer) request.getAttribute("accountId");
        Date datetime = DateUtil.parseDatetimeString(pickupTime);
        Result result = new Result();
        DriverReservation driverReservation = driverReservationService.getDriverReservationByConferenceIdAndUserId(conferenceId, userId);
        if (driverReservation.isDriverCheck() == false) {
            driverReservationService.setDriverReservationDriverCheck(conferenceId, userId, datetime, pickupSite, carNumber, accountId);
            result.setSuccess(true);
            result.setMessage(null);
        } else {
            result.setSuccess(false);
            result.setMessage("此预约已被其他司机抢先确定！");
        }
        return result;
    }
}
