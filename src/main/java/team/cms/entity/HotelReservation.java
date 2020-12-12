package team.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HotelReservation {

    private Integer hotelId;

    private Integer conferenceId;

    private Integer userId;

    private Date reserveTime;

    private boolean hotelCheck;

    private Date checkinTime;

    private String roomNumber;

    private boolean userCheck;
}
