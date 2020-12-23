package team.cms.service;

import org.apache.ibatis.annotations.Param;
import team.cms.entity.HotelReservation;

import java.util.Date;
import java.util.List;

public interface HotelReservationService {

    boolean allHotelReservationChecked(Integer conferenceId);

    HotelReservation getHotelReservationByUserId(Integer id, Integer userId);

    HotelReservation getHotelReservationByAccountId(Integer id, Integer accountId);

    List<HotelReservation> getHotelReservationByHotelAccountId(Integer hotelId);

    void setHotelReservationUserCheck(Integer conferenceId, Integer accountId);

    void setHotelReservationHotelCheck(Integer conferenceId, Integer userId, Date checkinTime, String roomNumber);
}
