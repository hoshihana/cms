package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.cms.entity.HotelReservation;

import java.util.List;

@Mapper
@Repository
public interface HotelReservationRepository {
    List<HotelReservation> getAllHotelReservationsByConferenceId(Integer id);

    HotelReservation getParticipantHotelReservation(@Param("id") Integer id, @Param("userId") Integer userId);

}
