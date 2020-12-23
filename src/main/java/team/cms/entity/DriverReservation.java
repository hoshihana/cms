package team.cms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DriverReservation {

    private Integer fleetId;

    private Integer conferenceId;

    private Integer userId;

    private Date reserveTime;

    private boolean driverCheck;

    private Integer driverId;

    private Date pickupTime;

    private String pickupSite;

    private String carNumber;

    private boolean userCheck;

}
