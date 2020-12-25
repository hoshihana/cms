package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Enrollment;
import team.cms.entity.HotelReservation;
import team.cms.entity.User;
import team.cms.result.HotelReservationResult;
import team.cms.result.Result;
import team.cms.service.EnrollmentService;
import team.cms.service.HotelReservationService;
import team.cms.service.UserService;
import team.cms.util.DateUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/hotel/reservation")
public class HotelReservationController {

    @Resource
    private HotelReservationService hotelReservationService;

    @Resource
    private UserService userService;

    @Resource
    private EnrollmentService enrollmentService;

    @PostMapping("/unchecked")
    public List<HotelReservationResult> getAllUncheckedReservations(HttpServletRequest request) {
        Integer accountId = (Integer) request.getAttribute("accountId");
        List<HotelReservation> list = hotelReservationService.getHotelReservationByHotelAccountId(accountId);
        List<HotelReservationResult> results = new LinkedList<>();
        for (HotelReservation hotelReservation : list) {
            if (!hotelReservation.isHotelCheck() && !hotelReservation.isUserCheck()) {
                HotelReservationResult hotelReservationResult = new HotelReservationResult();
                User user = userService.getUserById(hotelReservation.getUserId());
                Enrollment enrollment = enrollmentService.getEnrollmentByUserId(hotelReservation.getConferenceId(), hotelReservation.getUserId());
                hotelReservationResult.setConferenceId(hotelReservation.getHotelId());
                hotelReservationResult.setConferenceId(hotelReservation.getConferenceId());
                hotelReservationResult.setUserId(hotelReservation.getUserId());
                hotelReservationResult.setAccountId(user.getAccountId());
                hotelReservationResult.setName(user.getName());
                hotelReservationResult.setGender(user.getGender());
                hotelReservationResult.setResidentIdNumber(user.getResidentIdNumber());
                hotelReservationResult.setTelephone(user.getTelephone());
                hotelReservationResult.setStayStart(enrollment.getStayStart());
                hotelReservationResult.setStayEnd(enrollment.getStayEnd());
                hotelReservationResult.setStayNeeds(enrollment.getStayNeeds());
                hotelReservationResult.setReserveTime(hotelReservation.getReserveTime());
                hotelReservationResult.setHotelCheck(hotelReservation.isHotelCheck());
                hotelReservationResult.setCheckinTime(hotelReservation.getCheckinTime());
                hotelReservationResult.setRoomNumber(hotelReservation.getRoomNumber());
                hotelReservationResult.setUserCheck(hotelReservation.isUserCheck());
                results.add(hotelReservationResult);
            }
        }
        return results;
    }

    @PostMapping("/checked")
    public List<HotelReservationResult> getAllCheckedReservations(HttpServletRequest request) {
        Integer accountId = (Integer) request.getAttribute("accountId");
        List<HotelReservation> list = hotelReservationService.getHotelReservationByHotelAccountId(accountId);
        List<HotelReservationResult> results = new LinkedList<>();
        for (HotelReservation hotelReservation : list) {
            if (hotelReservation.isHotelCheck() && !hotelReservation.isUserCheck()) {
                HotelReservationResult hotelReservationResult = new HotelReservationResult();
                User user = userService.getUserById(hotelReservation.getUserId());
                Enrollment enrollment = enrollmentService.getEnrollmentByUserId(hotelReservation.getConferenceId(), hotelReservation.getUserId());
                hotelReservationResult.setConferenceId(hotelReservation.getHotelId());
                hotelReservationResult.setConferenceId(hotelReservation.getConferenceId());
                hotelReservationResult.setUserId(hotelReservation.getUserId());
                hotelReservationResult.setAccountId(user.getAccountId());
                hotelReservationResult.setName(user.getName());
                hotelReservationResult.setGender(user.getGender());
                hotelReservationResult.setResidentIdNumber(user.getResidentIdNumber());
                hotelReservationResult.setTelephone(user.getTelephone());
                hotelReservationResult.setStayStart(enrollment.getStayStart());
                hotelReservationResult.setStayEnd(enrollment.getStayEnd());
                hotelReservationResult.setStayNeeds(enrollment.getStayNeeds());
                hotelReservationResult.setReserveTime(hotelReservation.getReserveTime());
                hotelReservationResult.setHotelCheck(hotelReservation.isHotelCheck());
                hotelReservationResult.setCheckinTime(hotelReservation.getCheckinTime());
                hotelReservationResult.setRoomNumber(hotelReservation.getRoomNumber());
                hotelReservationResult.setUserCheck(hotelReservation.isUserCheck());
                results.add(hotelReservationResult);
            }
        }
        return results;
    }

    @PostMapping("/ended")
    public List<HotelReservationResult> getAllEndedReservations(HttpServletRequest request) {
        Integer accountId = (Integer) request.getAttribute("accountId");
        List<HotelReservation> list = hotelReservationService.getHotelReservationByHotelAccountId(accountId);
        List<HotelReservationResult> results = new LinkedList<>();
        for (HotelReservation hotelReservation : list) {
            if (hotelReservation.isHotelCheck() && hotelReservation.isUserCheck()) {
                HotelReservationResult hotelReservationResult = new HotelReservationResult();
                User user = userService.getUserById(hotelReservation.getUserId());
                Enrollment enrollment = enrollmentService.getEnrollmentByUserId(hotelReservation.getConferenceId(), hotelReservation.getUserId());
                hotelReservationResult.setConferenceId(hotelReservation.getHotelId());
                hotelReservationResult.setConferenceId(hotelReservation.getConferenceId());
                hotelReservationResult.setUserId(hotelReservation.getUserId());
                hotelReservationResult.setAccountId(user.getAccountId());
                hotelReservationResult.setName(user.getName());
                hotelReservationResult.setGender(user.getGender());
                hotelReservationResult.setResidentIdNumber(user.getResidentIdNumber());
                hotelReservationResult.setTelephone(user.getTelephone());
                hotelReservationResult.setStayStart(enrollment.getStayStart());
                hotelReservationResult.setStayEnd(enrollment.getStayEnd());
                hotelReservationResult.setStayNeeds(enrollment.getStayNeeds());
                hotelReservationResult.setReserveTime(hotelReservation.getReserveTime());
                hotelReservationResult.setHotelCheck(hotelReservation.isHotelCheck());
                hotelReservationResult.setCheckinTime(hotelReservation.getCheckinTime());
                hotelReservationResult.setRoomNumber(hotelReservation.getRoomNumber());
                hotelReservationResult.setUserCheck(hotelReservation.isUserCheck());
                results.add(hotelReservationResult);
            }
        }
        return results;
    }

    @PostMapping("/check")
    public Result checkHotelReservation(Integer conferenceId, Integer userId, String checkinTime, String roomNumber) {
        hotelReservationService.setHotelReservationHotelCheck(conferenceId, userId, DateUtil.parseDatetimeString(checkinTime), roomNumber);
        return new Result(true, null);
    }
}
