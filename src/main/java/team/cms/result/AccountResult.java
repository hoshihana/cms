package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.cms.entity.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResult {

    private Integer accountId;

    private String username;

    private Role role;

    private Integer roleId;
}
