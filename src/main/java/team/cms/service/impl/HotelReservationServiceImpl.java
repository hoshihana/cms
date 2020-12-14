package team.cms.service.impl;

import team.cms.entity.HotelReservation;
import team.cms.repository.EnrollmentRepository;
import team.cms.repository.HotelReservationRepository;
import team.cms.service.HotelReservationService;

import javax.annotation.Resource;
import java.util.List;

public class HotelReservationServiceImpl implements HotelReservationService {

    @Resource
    HotelReservationRepository hotelReservationRepository;

    @Override
    public List<HotelReservation> getAllHotelReservationsByConferenceId(Integer id){
        return hotelReservationRepository.getAllHotelReservationsByConferenceId(id);
    }

}
