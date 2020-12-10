package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordModifyResult {

    private boolean success;

    private boolean oldPasswordCorrect;

    private String message;
}
