package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.entity.Driver;
import team.cms.entity.enums.Gender;
import team.cms.result.Result;
import team.cms.service.DriverService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/driver/profile")
public class DriverProfileController {

    @Resource
    private DriverService driverService;

    @PostMapping("")
    public Driver getDriverProfile(HttpServletRequest request) {
        Integer accountId = (Integer) request.getAttribute("accountId");
        return driverService.getDriverByAccountId(accountId);
    }

    @PostMapping("/modify")
    public Result modifyDriverMessage(HttpServletRequest request, String name, Gender gender, String residentIdNumber, String telephone) {
        Integer accountId = (Integer) request.getAttribute("accountId");
        Driver driver = new Driver();
        driver.setAccountId(accountId);
        driver.setName(name);
        driver.setResidentIdNumber(residentIdNumber);
        driver.setTelephone(telephone);
        driver.setGender(gender);
        driverService.modifyDriver(driver);
        return new Result(true, null);
    }
}
