package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Conference;
import team.cms.entity.Enrollment;
import team.cms.entity.HotelReservation;
import team.cms.entity.User;
import team.cms.result.CountResult;
import team.cms.result.Result;
import team.cms.service.ConferenceService;
import team.cms.service.EnrollmentService;
import team.cms.service.HotelReservationService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/conference")
public class ConferenceController {

    @Resource
    ConferenceService conferenceService;

    @Resource
    EnrollmentService enrollmentService;

    @Resource
    HotelReservationService hotelReservationService;

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
    public Result removeEnrollment(Integer id, Integer userId) {

        boolean flag = enrollmentService.removeEnrollment(id, userId);
        if (flag)
            return new Result(true, null);
        else
            return new Result(false, "删除失败！");
    }

    @PostMapping("/hotelReservation")
    public List<HotelReservation> getAllHotelReservations(Integer id){
        return hotelReservationService.getAllHotelReservationsByConferenceId(id);
    }

    @PostMapping("/hotelReservation/get")
    public HotelReservation getParticipantHotelReservation(Integer id, Integer userId){
        return hotelReservationService.getParticipantHotelReservation(id, userId);
    }

    @PostMapping("/hotelReservation/checkAll")
    public boolean isAllHotelReservationChecked(Integer id){
        List<HotelReservation> hotelReservations=hotelReservationService.getAllHotelReservationsByConferenceId(id);
        for(HotelReservation h:hotelReservations){
            if(!h.isHotelCheck()) return false;
        }
        return true;
    }

    @PostMapping("/hotelReservation/check")
    public boolean checkHotelReservation(Integer id){
        List<HotelReservation> hotelReservations=hotelReservationService.getAllHotelReservationsByConferenceId(id);
        for(HotelReservation h:hotelReservations){
            if(!h.isHotelCheck()) return false;
        }
        return true;
    }
}
