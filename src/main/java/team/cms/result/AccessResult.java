package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.cms.entity.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessResult {

    private boolean success;

    private Role requiredRole;

    private Role currentRole;

    private String message;

}
