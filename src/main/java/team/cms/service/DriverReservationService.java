package team.cms.service;

import team.cms.entity.DriverReservation;

public interface DriverReservationService {

    DriverReservation getDirverReservationByConferenceIdAndUserId(Integer id,Integer userId);

    DriverReservation getDirverReservationByConferenceId(Integer id,Integer accountId);
}
