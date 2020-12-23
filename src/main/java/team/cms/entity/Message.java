package team.cms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private Integer id;

    private Integer senderId;

    private Integer recipientId;

    private String content;

    private Date sendTime;

    private Boolean read;

}
