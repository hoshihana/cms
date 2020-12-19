package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FleetProfileResult {

    Integer id;

    String name;

    String detail;

    String telephone;

    Integer driverAmount;
}
