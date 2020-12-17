package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Driver;
import team.cms.repository.DriverRepository;
import team.cms.service.DriverService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Resource
    private DriverRepository driverRepository;


    @Override
    public Driver getDriverByAccountId(Integer accountId) {
        return driverRepository.getDriverByAccountId(accountId);
    }

    @Override
    public List<Driver> getFleetDrivers(Integer fleetId) {
        return driverRepository.getFleetDrivers(fleetId);
    }

    @Override
    public void modifyDriver(Driver driver) {
        driverRepository.modifyDrivers(driver);
    }

    @Override
    public Driver getDriverById(Integer id) {
        return driverRepository.getDriverById(id);
    }
}
