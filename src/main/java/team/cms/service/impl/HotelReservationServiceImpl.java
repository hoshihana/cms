package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.HotelReservation;
import team.cms.repository.ConferenceRepository;
import team.cms.repository.HotelRepository;
import team.cms.repository.HotelReservationRepository;
import team.cms.repository.UserRepository;
import team.cms.service.DriverReservationService;
import team.cms.service.DriverService;
import team.cms.service.HotelReservationService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class HotelReservationServiceImpl implements HotelReservationService {

    @Resource
    UserRepository userRepository;

    @Resource
    HotelRepository hotelRepository;

    @Resource
    ConferenceRepository conferenceRepository;

    @Resource
    DriverReservationService driverReservationService;

    @Resource
    HotelReservationRepository hotelReservationRepository;

    @Override
    public boolean allHotelReservationChecked(Integer conferenceId) {
        List<HotelReservation> hotelReservations = hotelReservationRepository.getHotelReservationsByConferenceId(conferenceId);
        for(HotelReservation hotelReservation : hotelReservations) {
            if(!hotelReservation.isHotelCheck()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public HotelReservation getHotelReservationByUserId(Integer id, Integer userId) {
        return hotelReservationRepository.getHotelReservation(id, userId);
    }

    @Override
    public HotelReservation getHotelReservationByAccountId(Integer id, Integer accountId) {
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        return hotelReservationRepository.getHotelReservation(id, userId);
    }

    @Override
    public List<HotelReservation> getHotelReservationByHotelAccountId(Integer accountId) {
        Integer hotelId = hotelRepository.getHotelByAccountId(accountId).getId();
        return hotelReservationRepository.getHotelReservationsByHotelId(hotelId);
    }

    @Override
    public void setHotelReservationUserCheck(Integer conferenceId, Integer accountId) {
        Integer userId = userRepository.getUserByAccountId(accountId).getId();
        hotelReservationRepository.setHotelReservationUserCheck(conferenceId, userId);
    }

    @Override
    public void setHotelReservationHotelCheck(Integer conferenceId, Integer userId, Date checkinTime, String roomNumber) {
        hotelReservationRepository.setHotelReservationHotelCheck(conferenceId, userId, checkinTime, roomNumber);
        if(allHotelReservationChecked(conferenceId) && driverReservationService.allDriverReservationChecked(conferenceId)) {
            conferenceRepository.setConferenceReady(conferenceId);
        }
    }
}
