package team.cms.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.cms.entity.enums.Progress;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conference {

    private Integer id;

    private String number;

    private Integer userId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String name;

    private String detail;

    private String address;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date enrollTime;

    private String inviteCode;

    private Integer hotelId;

    private Integer fleetId;

    private Progress progress;
}

