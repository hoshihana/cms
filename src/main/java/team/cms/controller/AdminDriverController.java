package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.entity.Driver;
import team.cms.entity.enums.Gender;
import team.cms.entity.enums.Role;
import team.cms.result.DriverResult;
import team.cms.result.Result;
import team.cms.service.AccountService;
import team.cms.service.DriverService;
import team.cms.util.CipherUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/driver")
public class AdminDriverController {

    @Resource
    private DriverService driverService;
    @Resource
    private AccountService accountService;

    @PostMapping("/getAll")
    public List<DriverResult> getFleetDrivers(Integer fleetId)
    {
        List<Driver> drivers= driverService.getFleetDrivers(fleetId);
        List<DriverResult> driverResultList = new ArrayList<>();

        for (Driver driver : drivers) {
            DriverResult driverResult = new DriverResult();
            driverResult.setAccountId(driver.getAccountId());
            driverResult.setDriverId(driver.getId());
            Account account=accountService.getAccountById(driver.getAccountId());
            driverResult.setUsername(account.getUsername());
            driverResult.setName(driver.getName());
            driverResultList.add(driverResult);
        }
        return driverResultList;
    }

    @PostMapping("/profile/get")
    public Driver getDriverByDriverId(Integer driverId) {
        return driverService.getDriverById(driverId);
    }

    @PostMapping("/profile/modify")
    public Result modifyDriver(Integer driverId, String name, Gender gender, String residentIdNumber, String telephone) {
        Driver driver = new Driver();
        driver.setId(driverId);
        driver.setName(name);
        driver.setGender(gender);
        driver.setResidentIdNumber(residentIdNumber);
        driver.setTelephone(telephone);
        driverService.modifyDriver(driver);
        return new Result(true, null);
    }

    @PostMapping("/password/modify")
    public Result modifyDriverPassword(Integer driverId,String password) {
        Driver driver = driverService.getDriverById(driverId);
        Account account = new Account();
        account.setId(driver.getAccountId());
        account.setPassword(CipherUtil.encipherText(password));
        accountService.modifyPassword(account);
        return new Result(true,null);
    }

    @PostMapping("/add")
    public Result addDriverAccount(Integer fleetId, String username, String password){
        if(!accountService.usernameAvailable(username)) {
            return new Result(false, "用户名不可用");
        }
        driverService.addDriver(fleetId, username, CipherUtil.encipherText(password));
        return new Result(true,null);
    }
}
