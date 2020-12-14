package team.cms.service;

import org.apache.ibatis.annotations.Param;
import team.cms.entity.DriverReservation;

public interface DriverReservationService {

    DriverReservation getDirverReservationByConferenceIdAndUserId(Integer id,Integer userId);

    DriverReservation getDirverReservationByConferenceId(Integer id,Integer accountId);

    DriverReservation getUncheckedDriverReservationByFleetId(Integer accountId);

    DriverReservation getCheckDriverReservationByDriverId(Integer driverId);

    DriverReservation getEndedDriverReservationByDriverId(Integer driverId);

    void setDriverReservationUserCheck( Integer id, Integer accountId);

}
