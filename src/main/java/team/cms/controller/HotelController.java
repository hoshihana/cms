package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Hotel;
import team.cms.service.HotelService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Resource
    HotelService hotelService;

    @PostMapping("/getAll")
    List<Hotel> getAll(){
        return hotelService.getAll();
    }

    @PostMapping("/get")
    Hotel getHotelById(Integer id) {
        return hotelService.getHotelById(id);
    }

}
