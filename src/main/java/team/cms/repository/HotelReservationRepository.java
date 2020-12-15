package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.cms.entity.HotelReservation;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface HotelReservationRepository {


    List<HotelReservation> getHotelReservationsByHotelId(Integer hotelId);

    List<HotelReservation> getHotelReservationsByConferenceId(Integer id);

    HotelReservation getHotelReservation(@Param("id") Integer id, @Param("userId") Integer userId);

    void setHotelReservationUserCheck(@Param("conferenceId") Integer conferenceId, @Param("userId") Integer userId);

    void setHotelReservationHotelCheck(@Param("conferenceId") Integer conferenceId, @Param("userId") Integer userId, @Param("checkinTime") Date checkinTime, @Param("roomNumber")String roomNumber);
}
