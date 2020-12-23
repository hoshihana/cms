package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.cms.entity.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult {

    private boolean success;

    private String message;

    private String token;

    private String username;

    private Integer accountId;

    private Role role;
}
