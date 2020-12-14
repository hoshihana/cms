package team.cms.service;

import team.cms.entity.Hotel;
import team.cms.entity.User;
import team.cms.result.UserHotelReservation;

import java.util.List;

public interface HotelService {

    Hotel getHotelByAccountId(Integer accountId);

    List<Hotel> getAll();

    Hotel getHotelById(Integer id);

    void modifyHotel(Hotel hotel);

    List<UserHotelReservation> getAllReservationsByAccountId(Integer accountId);
}
