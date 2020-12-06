package team.cms.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.cms.entity.enums.Gender;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private Integer accountId;

    private String name;

    private Gender gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String residentIdNumber;

    private String telephone;

    private String email;

    private String workplace;

}
