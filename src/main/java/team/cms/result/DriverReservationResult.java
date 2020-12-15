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
public class DriverReservationResult {

    private Integer conferenceId;

    private Integer userId;

    private String name;

    private Gender gender;

    private String telephone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date arriveTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date reserveTime;

    private boolean driverCheck;

    private Integer driverId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pickupTime;

    private String pickupSite;

    private String carNumber;

    private boolean userCheck;
}
