package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.DriverReservation;
import team.cms.repository.DriverRepository;
import team.cms.repository.DriverReservationRepository;
import team.cms.repository.UserRepository;
import team.cms.service.DriverReservationService;

import javax.annotation.Resource;

@Service
public class DriverReservationServiceImpl implements DriverReservationService {

    @Resource
    DriverReservationRepository driverReservationRepository;
    @Resource

    UserRepository userRepository;


    @Override
    public DriverReservation getDirverReservationByConferenceIdAndUserId(Integer id, Integer userId) {
        return driverReservationRepository.getDriverReservation(id, userId);
    }

    @Override
    public DriverReservation getDirverReservationByConferenceId(Integer id, Integer accountId) {
        Integer userId=userRepository.getUserByAccountId(accountId).getId();
        return driverReservationRepository.getDriverReservation(id,userId);
    }
}
