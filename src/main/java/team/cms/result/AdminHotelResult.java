package team.cms.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminHotelResult {

    private Integer accountId;

    private String username;

    private Integer hotelId;

    private String name;
}
