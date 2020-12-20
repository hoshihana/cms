package team.cms.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.service.AccountService;
import team.cms.service.HotelService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/admin/hotel")
public class AdminHotelController {

    @Resource
    private HotelService hotelService;

    @PostMapping("/count")
    public Integer getHotelNumber(){
        return hotelService.getAll().size();
    }







}
