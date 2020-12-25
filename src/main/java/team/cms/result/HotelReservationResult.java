package team.cms.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.cms.entity.enums.Gender;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelReservationResult {

    private Integer hotelId;

    private Integer conferenceId;

    private Integer userId;

    private Integer accountId;

    private String name;

    private Gender gender;

    private String residentIdNumber;

    private String telephone;

    private Date stayStart;

    private Date stayEnd;

    private String stayNeeds;

    private Date reserveTime;

    private boolean hotelCheck;

    private Date checkinTime;

    private String roomNumber;

    private boolean userCheck;

}
