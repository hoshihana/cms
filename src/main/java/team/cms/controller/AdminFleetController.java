package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Fleet;
import team.cms.result.CountResult;
import team.cms.result.FleetResult;
import team.cms.result.Result;
import team.cms.service.FleetService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/fleet")
public class AdminFleetController {

    @Resource
    private FleetService fleetService;

    @PostMapping("/count")
    public CountResult getAmountOfFleet() {
        return new CountResult(fleetService.getAmountOfFleet());
    }

    @PostMapping("/getAll")
    public List<FleetResult> getAllFleets(){
        List<Fleet> fleetList = fleetService.getAll();
        List<FleetResult> fleetResultList = new ArrayList<>();

        for (Fleet fleet:fleetList) {
            FleetResult fleetResult = new FleetResult();
            fleetResult.setId(fleet.getId());
            fleetResult.setName(fleet.getName());
            System.out.println(fleet.getDriverAmount());
            fleetResult.setDriverAmount(fleet.getDriverAmount());
            fleetResultList.add(fleetResult);
        }
        return fleetResultList;
    }

    @PostMapping("/profile/get")
    public Fleet getFleetById(Integer fleetId){
        return fleetService.getFleetById(fleetId);
    }

    @PostMapping("/profile/modify")
    public Result modifyFleet(Integer fleetId,String name,String detail,String telephone){
        Fleet fleet = new Fleet();
        fleet.setId(fleetId);
        fleet.setName(name);
        fleet.setDetail(detail);
        fleet.setTelephone(telephone);
        fleetService.modifyFleet(fleet);
        return new Result(true,null);
    }

    @PostMapping("/add")
    public Result addFleet(String name,String detail,String telephone){
        Fleet fleet = new Fleet();
        fleet.setName(name);
        fleet.setDetail(detail);
        fleet.setTelephone(telephone);
        fleetService.addFleet(fleet);
        return new Result(true,null);
    }
}
