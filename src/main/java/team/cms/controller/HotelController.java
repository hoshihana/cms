package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Hotel;
import team.cms.service.HotelService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Resource
    private HotelService hotelService;

    @PostMapping("/getAll")
    public List<Hotel> getAll(){
        List<Hotel> hotels = hotelService.getAll();
        List<Hotel> result = new ArrayList<>();
        for(Hotel hotel : hotels) {
            if(hotel.getName() != null) {
                result.add(hotel);
            }
        }
        return result;
    }

    @PostMapping("/get")
    public Hotel getHotelById(Integer id) {
        return hotelService.getHotelById(id);
    }

}
