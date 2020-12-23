package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Fleet;
import team.cms.service.FleetService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/fleet")
public class FleetController {

    @Resource
    private FleetService fleetService;

    @PostMapping("/getAll")
    public List<Fleet> getAll()
    {
        return fleetService.getAll();
    }

    @PostMapping("/get")
    public Fleet getFleetById(Integer id)
    {
        return fleetService.getFleetById(id);
    }
}
