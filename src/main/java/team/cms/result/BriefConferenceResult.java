package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefConferenceResult {
    private Integer conferenceId;

    private String number;

    private String username;

    private String name;
}
