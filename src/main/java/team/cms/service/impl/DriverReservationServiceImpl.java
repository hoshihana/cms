package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Driver;
import team.cms.entity.DriverReservation;
import team.cms.repository.DriverRepository;
import team.cms.repository.DriverReservationRepository;
import team.cms.repository.UserRepository;
import team.cms.service.DriverReservationService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DriverReservationServiceImpl implements DriverReservationService {

    @Resource
    DriverReservationRepository driverReservationRepository;

    @Resource
    UserRepository userRepository;

    @Resource
    DriverRepository driverRepository;


    @Override
    public DriverReservation getDirverReservationByConferenceIdAndUserId(Integer id, Integer userId) {
        return driverReservationRepository.getDriverReservation(id, userId);
    }

    @Override
    public DriverReservation getDirverReservationByConferenceId(Integer id, Integer accountId) {
        Integer userId=userRepository.getUserByAccountId(accountId).getId();
        return driverReservationRepository.getDriverReservation(id,userId);
    }

    @Override
    public List<DriverReservation> getUncheckedDriverReservationByFleetId(Integer accountId) {
        Driver driver=new Driver();
        driver=driverRepository.getDriverByAccountId(accountId);
        Integer fleetId = driver.getFleetId();
        return driverReservationRepository.getUncheckedDriverReservationByFleetId(fleetId);
    }

    @Override
    public List<DriverReservation> getCheckDriverReservationByDriverId(Integer driverId) {
        return driverReservationRepository.getCheckDriverReservationByDriverId(driverId);
    }

    @Override
    public List<DriverReservation> getEndedDriverReservationByDriverId(Integer driverId) {
        return driverReservationRepository.getEndedDriverReservationByDriverId(driverId);
    }

    @Override
    public void setDriverReservationUserCheck(Integer id, Integer accountId) {
        Integer userId=userRepository.getUserByAccountId(accountId).getId();
        driverReservationRepository.setDriverReservationUserCheck(id,userId);
    }

    @Override
    public void setDriverReservationDriverCheck(Integer conferenceId, Integer userId, Date pickupTime, String pickupSite, String carNumber,Integer accountId) {
        Driver driver=new Driver();
        driver=driverRepository.getDriverByAccountId(accountId);
        driverReservationRepository.setDriverReservationDriverCheck(conferenceId,userId,pickupTime,pickupSite,carNumber,driver.getId());
    }

    @Override
    public boolean allDriverReservationChecked(Integer conferenceId) {
        return driverReservationRepository.countUncheckedDriverReservation(conferenceId) == 0;
    }
}
