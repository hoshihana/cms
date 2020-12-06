package team.cms.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private Integer id;

    private Integer senderId;

    private Integer recipientId;

    private String content;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    private Boolean read;

}
