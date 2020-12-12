package team.cms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date arriveTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date enrollTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stayStart;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stayEnd;

    private String stayNeeds;

    private String remark;

}
