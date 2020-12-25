package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverResult {

    private Integer accountId;

    private String username;

    private Integer driverId;

    private String name;

    private String telephone;
}
