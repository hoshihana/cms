package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FleetResult {

    private Integer id;

    private String name;

    private Integer driverAmount;

    private String telephone;
}
