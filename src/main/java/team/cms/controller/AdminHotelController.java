package team.cms.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Hotel;
import team.cms.result.AdminHotelResult;
import team.cms.service.AccountService;
import team.cms.service.HotelService;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/hotel")
public class AdminHotelController {

    @Resource
    private HotelService hotelService;

    @PostMapping("/count")
    public Integer getHotelNumber(){
        return hotelService.getAll().size();
    }

    @PostMapping("/getAll")
    public List<AdminHotelResult> getAllHotel(){
//        List<AdminHotelResult> resultList=new LinkedList<>();
//        List<Hotel> tempList=hotelService.getAll();
//
//        for(Hotel hotel:tempList){
//            resultList.add(new AdminHotelResult(hotel.getAccountId(),hotel.))
//        }
        return null;




    }










}
