package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Hotel;
import team.cms.repository.HotelRepository;
import team.cms.service.HotelService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Resource
    private HotelRepository hotelRepository;

    @Override
    public Hotel getHotelByAccountId(Integer accountId) {
        return hotelRepository.getHotelByAccountId(accountId);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.getAll();
    }

    @Override
    public Hotel getHotelById(Integer id) {
        return hotelRepository.getHotelById(id);
    }

    @Override
    public void modifyHotel(Hotel hotel) {
        hotelRepository.modifyHotel(hotel);
    }
}
