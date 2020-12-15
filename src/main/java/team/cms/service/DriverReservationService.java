package team.cms.service;

import org.apache.ibatis.annotations.Param;
import team.cms.entity.DriverReservation;

import java.util.Date;
import java.util.List;

public interface DriverReservationService {

    DriverReservation getDirverReservationByConferenceIdAndUserId(Integer id,Integer userId);

    DriverReservation getDirverReservationByConferenceId(Integer id,Integer accountId);

    List<DriverReservation> getUncheckedDriverReservationByFleetId(Integer accountId);

    List<DriverReservation> getCheckDriverReservationByDriverId(Integer driverId);

    List<DriverReservation> getEndedDriverReservationByDriverId(Integer driverId);

    void setDriverReservationUserCheck( Integer id, Integer accountId);

    void setDriverReservationDriverCheck(Integer conferenceId, Integer userId,Date pickupTime,String pickupSite, String carNumber,Integer driverId);

    boolean allDriverReservationChecked(Integer conferenceId);
}
