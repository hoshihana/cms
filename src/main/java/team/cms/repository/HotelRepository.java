package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team.cms.entity.Hotel;

import java.util.List;

@Mapper
@Repository
public interface HotelRepository {

    Hotel getHotelByAccountId(Integer accountId);

    List<Hotel> getAll();

    Hotel getHotelById(Integer id);

    void modifyHotel(Hotel hotel);

}
