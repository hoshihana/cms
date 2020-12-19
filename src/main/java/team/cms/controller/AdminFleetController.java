package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Fleet;
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
    FleetService fleetService;

    @PostMapping("/count")
    private Integer getAmountOfFleet() {
        return fleetService.getAmountOfFleet();
    }

    @PostMapping("/getAll")
    private List<FleetResult> getAllFleets(){
        List<Fleet> fleetList = fleetService.getAll();
        List<FleetResult> fleetResultList = new ArrayList<>();

        for (Fleet fleet:fleetList) {
            FleetResult fleetResult = new FleetResult();
            fleetResult.setId(fleet.getId());
            fleetResult.setName(fleet.getName());
            Integer newestDriverAmount = fleetService.getNumberOfDrivers(fleet.getId());
            fleetResult.setDriverAmount(newestDriverAmount);
            fleetResultList.add(fleetResult);
        }
        return fleetResultList;
    }

    @PostMapping("/profile/get")
    private Fleet getFleetById(Integer fleetId){
        Fleet fleet = fleetService.getFleetById(fleetId);
        Integer newestDriverAmount = fleetService.getNumberOfDrivers(fleet.getId());
        fleet.setDiverAmount(newestDriverAmount);
        return fleet;
    }

    @PostMapping("/profile/modify")
    private Result modifyFleet(Integer fleetId,String name,String detail,String telephone){
        Fleet fleet = new Fleet();
        fleet.setId(fleetId);
        fleet.setName(name);
        fleet.setDetail(detail);
        fleet.setTelephone(telephone);
        fleetService.modifyFleet(fleet);
        return new Result(true,null);
    }

    @PostMapping("/add")
    private Result addFleet(String name,String detail,String telephone){
        Fleet fleet = new Fleet();
        fleet.setName(name);
        fleet.setDetail(detail);
        fleet.setTelephone(telephone);
        fleetService.addFleet(fleet);
        return new Result(true,null);
    }
}
