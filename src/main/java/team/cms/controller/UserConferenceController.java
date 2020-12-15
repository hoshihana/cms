package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Conference;
import team.cms.entity.Enrollment;
import team.cms.result.CheckResult;
import team.cms.result.ParticipateConferenceResult;
import team.cms.result.Result;
import team.cms.service.ConferenceService;
import team.cms.service.EnrollmentService;
import team.cms.util.DateUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/user/conference")
public class UserConferenceController {

    @Resource
    ConferenceService conferenceService;

    @Resource
    EnrollmentService enrollmentService;

    @PostMapping("/created/ongoing")
    List<Conference> getOngoingAndCreatedConference(HttpServletRequest request) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return conferenceService.getOngoingAndCreatedConference(accountId);
    }

    @PostMapping("/participated/ongoing")
    List<Conference> getOngoingAndParticipatedConference(HttpServletRequest request) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return conferenceService.getOngoingAndParticipatedConference(accountId);
    }

    @PostMapping("/created/ended")
    List<Conference> getEndedAndCreatedConference(HttpServletRequest request) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return conferenceService.getEndedAndCreatedConference(accountId);
    }

    @PostMapping("/participated/ended")
    List<Conference> getEndedAndParticipatedConference(HttpServletRequest request) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return conferenceService.getEndedAndParticipatedConference(accountId);
    }

    @PostMapping("/created/checkById")
    CheckResult checkOwnerById(HttpServletRequest request, Integer id) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return  new CheckResult(conferenceService.checkOwnerById(accountId, id));
    }

    @PostMapping("/created/checkByNumber")
    CheckResult checkOwnerByNumber(HttpServletRequest request, String number) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return  new CheckResult(conferenceService.checkOwnerByNumber(accountId, number));
    }

    @PostMapping("/participated/checkById")
    CheckResult checkParticipantById(HttpServletRequest request, Integer id) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return  new CheckResult(conferenceService.checkParticipantById(accountId, id));
    }

    @PostMapping("/participated/checkByNumber")
    CheckResult checkParticipantById(HttpServletRequest request, String number) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return  new CheckResult(conferenceService.checkParticipantByNumber(accountId, number));
    }

    @PostMapping("/create")
    Result createConference(HttpServletRequest request, String name, String detail, String address, String startTime, String endTime, String enrollTime, String inviteCode) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        Conference conference = new Conference();
        conference.setName(name);
        conference.setDetail(detail);
        conference.setAddress(address);
        conference.setStartTime(DateUtil.parseDatetimeString(startTime));
        conference.setEndTime(DateUtil.parseDatetimeString(endTime));
        conference.setEnrollTime(DateUtil.parseDatetimeString(enrollTime));
        conference.setInviteCode(inviteCode);
        conferenceService.addConference(accountId, conference);
        return new Result(true, null);
    }

    @PostMapping("/participate")
    ParticipateConferenceResult participateConference(HttpServletRequest request, String inviteCode, Integer id,
                                                      String tripNumber, String arriveTime, String stayStart, String stayEnd, String stayNeeds, String remark) {

        Integer accountId = (Integer)request.getAttribute("accountId");

        if(conferenceService.checkInviteCode(id, inviteCode)){
            Enrollment enrollment=new Enrollment();
            enrollment.setConferenceId(id);
            enrollment.setTripNumber(tripNumber);
            enrollment.setArriveTime(DateUtil.parseDatetimeString(arriveTime));
            enrollment.setEnrollTime(new Date());
            enrollment.setStayStart(DateUtil.parseDateString(stayStart));
            enrollment.setStayEnd(DateUtil.parseDateString(stayEnd));
            enrollment.setStayNeeds(stayNeeds);
            enrollment.setRemark(remark);
            if(enrollmentService.participateConference(accountId, enrollment))
                return new ParticipateConferenceResult(true, true, null);
            else
                return new ParticipateConferenceResult(false, true, "创建参加信息失败！");

        }
        else return new ParticipateConferenceResult(true, false, "邀请码错误！");
    }


}
