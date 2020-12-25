package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefUserResult {
    private Integer accountId;

    private String username;

    private Integer userId;

    private String name;

    private String telephone;
}
