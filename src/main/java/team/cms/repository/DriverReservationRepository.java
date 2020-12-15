package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.cms.entity.DriverReservation;

import java.util.Date;

@Mapper
@Repository
public interface DriverReservationRepository {

    DriverReservation getDriverReservation(@Param("id") Integer id, @Param("userId") Integer userId);

    void addDriverReservation(DriverReservation driverReservation);

    DriverReservation getUncheckedDriverReservationByFleetId(Integer fleetId);

    DriverReservation getCheckDriverReservationByDriverId(Integer driverId);

    DriverReservation getEndedDriverReservationByDriverId(Integer driverId);

    boolean allReservationChecked(Integer conferenceId);

    void setDriverReservationUserCheck(@Param("id") Integer id, @Param("userId") Integer userId);

    void setDriverReservationDriverCheck(@Param("conferenceId") Integer conferenceId, @Param("userId") Integer userId, @Param("pickupTime") Date pickupTime, @Param("pickupSite") String pickupSite, @Param("carNumber") String carNumber);
}
