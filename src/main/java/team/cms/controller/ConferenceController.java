package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Conference;
import team.cms.service.ConferenceService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/conference")
public class ConferenceController {

    @Resource
    ConferenceService conferenceService;

    @PostMapping("/getById")
    Conference getConferenceById(Integer id) {
        return conferenceService.getConferenceById(id);
    }

    @PostMapping("/getByNumber")
    Conference getConferenceByNumber(String number) {
        return conferenceService.getConferenceByNumber(number);
    }
}
