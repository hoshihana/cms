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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/driver/reservation")
public class DriverReservationController {

    @Resource
    DriverReservationService driverReservationService;
    @Resource
    DriverRepository driverRepository;
    @Resource
    UserRepository userRepository;
    @Resource
    EnrollmentRepository enrollmentRepository;

    @PostMapping("/unchecked")
    DriverReservationResult getUncheckedReservation(HttpServletRequest request) {
        DriverReservation driverReservation = new DriverReservation();
        Integer accountId = (Integer)request.getAttribute("accountId");

        driverReservation = driverReservationService.getUncheckedDriverReservationByFleetId(accountId);

        User user = new User();
        user = userRepository.getUserByAccountId(accountId);

        Enrollment enrollment = new Enrollment();
        enrollment = enrollmentRepository.getEnrollmentInfo(driverReservation.getConferenceId(),user.getId());

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

        return driverReservationResult;
    }

    @PostMapping("/checked")
    DriverReservationResult getCheckedReservation(HttpServletRequest request){
        DriverReservation driverReservation = new DriverReservation();
        Integer accountId = (Integer)request.getAttribute("accountId");

        Driver driver = new Driver();
        driver = driverRepository.getDriverByAccountId(accountId);

        driverReservation = driverReservationService.getCheckDriverReservationByDriverId(driver.getId());

        User user = new User();
        user = userRepository.getUserByAccountId(accountId);

        Enrollment enrollment = new Enrollment();
        enrollment = enrollmentRepository.getEnrollmentInfo(driverReservation.getConferenceId(),user.getId());

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

        return driverReservationResult;
    }

    @PostMapping("/ended")
    DriverReservationResult getEndedReservation(HttpServletRequest request){

        DriverReservation driverReservation = new DriverReservation();
        Integer accountId = (Integer)request.getAttribute("accountId");

        Driver driver = new Driver();
        driver = driverRepository.getDriverByAccountId(accountId);


        driverReservation = driverReservationService.getEndedDriverReservationByDriverId(driver.getId());

        User user = new User();
        user = userRepository.getUserByAccountId(accountId);

        Enrollment enrollment = new Enrollment();
        enrollment = enrollmentRepository.getEnrollmentInfo(driverReservation.getConferenceId(),user.getId());

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

        return driverReservationResult;
    }

}
