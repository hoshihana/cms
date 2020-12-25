package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefConferenceResult {
    private Integer conferenceId;

    private String number;

    private String username;

    private String name;

    private Date createTime;

    private Date startTime;

    private Date endTime;
}
