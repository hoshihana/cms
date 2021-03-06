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

    private Integer accountId;

    private String name;

    private Gender gender;

    private String telephone;

    private Date arriveTime;

    private String arriveSite;

    private Date reserveTime;

    private boolean driverCheck;

    private Integer driverId;

    private Date pickupTime;

    private String pickupSite;

    private String carNumber;

    private boolean userCheck;
}
