package team.cms.service;

import team.cms.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel getHotelByAccountId(Integer accountId);

    List<Hotel> getAll();

    Hotel getHotelById(Integer id);

    void addHotel(String username, String password);

    void modifyHotel(Hotel hotel);

}
