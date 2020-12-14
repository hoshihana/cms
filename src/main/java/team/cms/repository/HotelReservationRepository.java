package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team.cms.entity.HotelReservation;

import java.util.List;

@Mapper
@Repository
public interface HotelReservationRepository {
    List<HotelReservation> getAllReservationsByConferenceId(Integer id);
}
