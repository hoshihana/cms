package team.cms.service;

import org.springframework.stereotype.Service;
import team.cms.entity.Driver;
import team.cms.entity.enums.Gender;

import java.util.List;

public interface DriverService {

    List<Driver> getFleetDrivers(Integer fleetId);

    Driver getDriverByAccountId(Integer accountId);

    Driver getDriverById(Integer id);

    void addDriver(Integer fleetId, String username, String password, String name, Gender gender,String residentIdNumber,String telephone);

    void modifyDriver(Driver driver);
}
