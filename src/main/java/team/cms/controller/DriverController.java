package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Driver;
import team.cms.service.DriverService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    @Resource
    private DriverService driverService;

    @PostMapping("/getByFleetId")
    public List<Driver> getFleetDrivers(Integer fleetId)
    {
        List<Driver> drivers= driverService.getFleetDrivers(fleetId);
        return drivers;
    }

    @PostMapping("/getById")
    public Driver getDriverById(Integer id)
    {
        return driverService.getDriverById(id);
    }
}
