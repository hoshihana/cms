package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.entity.Conference;
import team.cms.entity.enums.Progress;
import team.cms.result.BriefConferenceResult;
import team.cms.result.CountResult;
import team.cms.result.Result;
import team.cms.service.AccountService;
import team.cms.service.ConferenceService;
import team.cms.util.DateUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/conference")
public class AdminConferenceController {

    @Resource
    ConferenceService conferenceService;

    @Resource
    AccountService accountService;

    @PostMapping("/count")
    public CountResult countConference() {
        return new CountResult(conferenceService.countConference());
    }

    @PostMapping("/getAll")
    public List<BriefConferenceResult> getAllConference() {
        List<Conference> conferences = conferenceService.getAllOngoingConference();
        List<BriefConferenceResult> briefConferenceResults = new ArrayList<>();
        for(Conference conference : conferences) {
            Account account = accountService.getAccountByUserId(conference.getUserId());
            briefConferenceResults.add(new BriefConferenceResult(conference.getId(), conference.getNumber(), account.getUsername(), conference.getName()));
        }
        return briefConferenceResults;
    }

    @PostMapping("/remove")
    public Result removeConference(Integer conferenceId) {
        Conference conference = conferenceService.getConferenceById(conferenceId);
        if(conference.getProgress() != Progress.ENROLLMENT && conference.getProgress() != Progress.OWNER_CONFIRM) {
            return new Result(false, "该会议已由发起者确认，无法删除");
        } else {
            conferenceService.removeConference(conferenceId);
            return new Result(true, null);
        }
    }

    @PostMapping("/get")
    public Conference getConference(Integer conferenceId) {
        return conferenceService.getConferenceById(conferenceId);
    }

    @PostMapping("/reset")
    public Result resetConference(Integer conferenceId, String name, String detail, String address, String startTime, String endTime, String enrollTime, String inviteCode) {
        Conference conference = conferenceService.getConferenceById(conferenceId);
        if(conference.getProgress() != Progress.ENROLLMENT && conference.getProgress() != Progress.OWNER_CONFIRM) {
            return new Result(false, "该会议已由发起者确认，无法重置");
        } else {
            conference.setName(name);
            conference.setDetail(detail);
            conference.setAddress(address);
            conference.setStartTime(DateUtil.parseDatetimeString(startTime));
            conference.setEndTime(DateUtil.parseDatetimeString(endTime));
            conference.setEnrollTime(DateUtil.parseDatetimeString(enrollTime));
            conference.setInviteCode(inviteCode);
            conference.setProgress(Progress.ENROLLMENT);
            conferenceService.modifyConference(conference);
            return new Result(true, null);
        }
    }
}
