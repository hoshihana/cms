package team.cms.service;

import org.springframework.stereotype.Service;
import team.cms.entity.Driver;

import java.util.List;

public interface DriverService {

    List<Driver> getFleetDrivers(Integer fleetId);

    Driver getDriverByAccountId(Integer accountId);

    Driver getDriverById(Integer id);

    void modifyDriver(Driver driver);
}
