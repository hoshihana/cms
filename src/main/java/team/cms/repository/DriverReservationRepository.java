package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.cms.entity.DriverReservation;

import java.util.Date;

import java.util.List;

@Mapper
@Repository
public interface DriverReservationRepository {

    DriverReservation getDriverReservation(@Param("id") Integer id, @Param("userId") Integer userId);

    void addDriverReservation(DriverReservation driverReservation);

    List<DriverReservation> getUncheckedDriverReservationByFleetId(Integer fleetId);

    List<DriverReservation> getCheckDriverReservationByDriverId(Integer driverId);

    List<DriverReservation> getEndedDriverReservationByDriverId(Integer driverId);

    Integer countUncheckedDriverReservation(Integer conferenceId);

    void setDriverReservationUserCheck(@Param("id") Integer id, @Param("userId") Integer userId);

    void setDriverReservationDriverCheck(@Param("conferenceId") Integer conferenceId, @Param("userId") Integer userId, @Param("pickupTime") Date pickupTime, @Param("pickupSite") String pickupSite, @Param("carNumber") String carNumber,@Param("dirverId")Integer driverId);

}
