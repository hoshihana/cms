package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipateConferenceResult {
    private boolean success;

    private boolean inviteCodeCorrect;

    private String message;
}
