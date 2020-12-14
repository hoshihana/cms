package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Hotel;
import team.cms.result.UserHotelReservation;
import team.cms.service.HotelService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
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

    @PostMapping("/reservation/unchecked")
    List<UserHotelReservation> getAllUncheckedReservations(HttpServletRequest request){
        Integer accountId= (Integer) request.getAttribute("accountId");
        List<UserHotelReservation> list=hotelService.getAllReservationsByAccountId(accountId);
        List<UserHotelReservation> results=new LinkedList<>();

        for(UserHotelReservation reservation:list){
            if(!reservation.isHotelCheck()&&!reservation.isUserCheck()) results.add(reservation);
        }
        return results;
    }

    @PostMapping("/reservation/checked")
    List<UserHotelReservation> getAllCheckedReservations(HttpServletRequest request){
        Integer accountId= (Integer) request.getAttribute("accountId");
        List<UserHotelReservation> list=hotelService.getAllReservationsByAccountId(accountId);
        List<UserHotelReservation> results=new LinkedList<>();

        for(UserHotelReservation reservation:list){
            if(reservation.isHotelCheck()&&!reservation.isUserCheck()) results.add(reservation);
        }
        return results;
    }

}
