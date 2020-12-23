package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Hotel;
import team.cms.result.Result;
import team.cms.service.HotelService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/hotel/profile")
public class HotelProfileController {

    @Resource
    private HotelService hotelService;

    @PostMapping("")
    public Hotel getHotelProfile(HttpServletRequest request) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        return hotelService.getHotelByAccountId(accountId);
    }

    @PostMapping("/modify")
    public Result modifyHotel(HttpServletRequest request,String name,String address,String detail,String telephone) {
        Integer accountId = (Integer)request.getAttribute("accountId");
        Hotel hotel=new Hotel();
        hotel.setAccountId(accountId);
        hotel.setName(name);
        hotel.setDetail(detail);
        hotel.setAddress(address);
        hotel.setTelephone(telephone);
        hotelService.modifyHotel(hotel);
        return new Result(true,null);
    }
}
