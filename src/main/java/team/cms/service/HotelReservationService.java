package team.cms.service;

import team.cms.entity.HotelReservation;

import java.util.List;

public interface HotelReservationService {
    List<HotelReservation> getAllHotelReservationsByConferenceId(Integer id);

    HotelReservation getParticipantHotelReservation(Integer id, Integer userId);
}
