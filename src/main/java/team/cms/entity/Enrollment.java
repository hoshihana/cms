package team.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Enrollment {
    private Integer userId;

    private Integer conferenceId;

    private String tripNumber;

    private Date arriveTime;

    private Date enrollTime;

    private Date stayStart;

    private Date stayEnd;

    private String stayNeeds;

    private String remark;

}
