package team.cms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.cms.entity.enums.Progress;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conference {

    private Integer id;

    private String number;

    private Integer userId;

    private Date createTime;

    private String name;

    private String detail;

    private String address;

    private Date startTime;

    private Date endTime;

    private Date enrollTime;

    private String inviteCode;

    private Integer hotelId;

    private Integer fleetId;

    private Progress progress;
}

