package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.cms.entity.DriverReservation;

@Mapper
@Repository
public interface DriverReservationRepository {

    DriverReservation getDriverReservation(@Param("id") Integer id, @Param("userId") Integer userId);

    void addDriverReservation(DriverReservation driverReservation);

    DriverReservation getUncheckedDriverReservationByFleetId(Integer fleetId);

    DriverReservation getCheckDriverReservationByDriverId(Integer driverId);

    DriverReservation getEndedDriverReservationByDriverId(Integer driverId);

}
