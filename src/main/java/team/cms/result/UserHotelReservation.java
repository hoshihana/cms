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
public class UserHotelReservation {
    private Integer conferenceId;

    private Integer userId;

    private String name;

    private Gender gender;

    private String residentIdNumber;

    private String telephone;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stayStart;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stayEnd;

    private String stayNeeds;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date reserveTime;

    private boolean hotelCheck;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkinTime;

    private String roomNumber;

    private boolean userCheck;

}
