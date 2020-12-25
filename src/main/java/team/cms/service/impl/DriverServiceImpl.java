package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Account;
import team.cms.entity.Driver;
import team.cms.entity.enums.Gender;
import team.cms.entity.enums.Role;
import team.cms.repository.AccountRepository;
import team.cms.repository.DriverRepository;
import team.cms.service.DriverService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Resource
    private DriverRepository driverRepository;

    @Resource
    private AccountRepository accountRepository;

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
    public void addDriver(Integer fleetId, String username, String password, String name, Gender gender, String residentIdNumber, String telephone) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole(Role.DRIVER);
        accountRepository.addAccount(account);
        Driver driver = new Driver();
        driver.setAccountId(account.getId());
        driver.setFleetId(fleetId);
        driver.setName(name);
        driver.setGender(gender);
        driver.setResidentIdNumber(residentIdNumber);
        driver.setTelephone(telephone);
        driverRepository.addDriver(driver);
    }

    @Override
    public Driver getDriverById(Integer id) {
        return driverRepository.getDriverById(id);
    }
}
