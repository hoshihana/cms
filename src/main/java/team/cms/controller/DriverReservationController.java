package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.*;
import team.cms.repository.AccountRepository;
import team.cms.repository.DriverRepository;
import team.cms.repository.EnrollmentRepository;
import team.cms.repository.UserRepository;
import team.cms.result.DriverReservationResult;
import team.cms.result.Result;
import team.cms.service.DriverReservationService;
import team.cms.service.DriverService;
import team.cms.service.EnrollmentService;
import team.cms.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/driver/reservation")
public class DriverReservationController {

    @Resource
    DriverReservationService driverReservationService;
    @Resource
    DriverService driverService;
    @Resource
    UserService userService;
    @Resource
    EnrollmentService enrollmentService;

    @PostMapping("/unchecked")
    List<DriverReservationResult> getUncheckedReservation(HttpServletRequest request) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        List<DriverReservation> driverReservationList = driverReservationService.getUncheckedDriverReservationByFleetId(accountId);
        List<DriverReservationResult> driverReservationResultList= new ArrayList<>();

        for (DriverReservation driverReservation:driverReservationList)
        {
            Integer userId=driverReservation.getUserId();
            User user = new User();
            user = userService.getUserById(userId);

            Enrollment enrollment = new Enrollment();
            enrollment = enrollmentService.getEnrollmentInfo(driverReservation.getConferenceId(),user.getId());

            DriverReservationResult driverReservationResult = new DriverReservationResult();
            driverReservationResult.setConferenceId(driverReservation.getConferenceId());
            driverReservationResult.setUserId(user.getId());
            driverReservationResult.setName(user.getName());
            driverReservationResult.setGender(user.getGender());
            driverReservationResult.setTelephone(user.getTelephone());
            driverReservationResult.setArriveTime(enrollment.getArriveTime());
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
    List<DriverReservationResult> getCheckedReservation(HttpServletRequest request){
        Integer accountId = (Integer)request.getAttribute("accountId");


        Driver driver = new Driver();
        driver = driverService.getDriverByAccountId(accountId);

        List<DriverReservation> driverReservationList = driverReservationService.getCheckDriverReservationByDriverId(driver.getId());
        List<DriverReservationResult> driverReservationResultList= new ArrayList<>();


        for (DriverReservation driverReservation:driverReservationList)
        {
            Integer userId=driverReservation.getUserId();
            User user = new User();
            user = userService.getUserById(userId);

            Enrollment enrollment = new Enrollment();
            enrollment = enrollmentService.getEnrollmentInfo(driverReservation.getConferenceId(),user.getId());

            DriverReservationResult driverReservationResult = new DriverReservationResult();
            driverReservationResult.setConferenceId(driverReservation.getConferenceId());
            driverReservationResult.setUserId(user.getId());
            driverReservationResult.setName(user.getName());
            driverReservationResult.setGender(user.getGender());
            driverReservationResult.setTelephone(user.getTelephone());
            driverReservationResult.setArriveTime(enrollment.getArriveTime());
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
    List<DriverReservationResult> getEndedReservation(HttpServletRequest request){

        Integer accountId = (Integer)request.getAttribute("accountId");

        Driver driver = new Driver();
        driver = driverService.getDriverByAccountId(accountId);


        List<DriverReservation> driverReservationList = driverReservationService.getEndedDriverReservationByDriverId(driver.getId());
        List<DriverReservationResult> driverReservationResultList= new ArrayList<>();

        for (DriverReservation driverReservation:driverReservationList)
        {
            Integer userId=driverReservation.getUserId();
            User user = new User();
            user = userService.getUserById(userId);

            Enrollment enrollment = new Enrollment();
            enrollment = enrollmentService.getEnrollmentInfo(driverReservation.getConferenceId(),user.getId());

            DriverReservationResult driverReservationResult = new DriverReservationResult();
            driverReservationResult.setConferenceId(driverReservation.getConferenceId());
            driverReservationResult.setUserId(user.getId());
            driverReservationResult.setName(user.getName());
            driverReservationResult.setGender(user.getGender());
            driverReservationResult.setTelephone(user.getTelephone());
            driverReservationResult.setArriveTime(enrollment.getArriveTime());
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

}
