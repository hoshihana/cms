package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Fleet;
import team.cms.repository.FleetRepository;
import team.cms.service.FleetService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FleetServiceImpl implements FleetService {

    @Resource
    private FleetRepository fleetRepository;

    @Override
    public List<Fleet> getAll() {
        return fleetRepository.getAll();
    }

    @Override
    public Fleet getFleetById(Integer id) {
        return fleetRepository.getFleetById(id);
    }

    @Override
    public Integer getAmountOfFleet() {
        return fleetRepository.getAmountOfFleet();
    }

    @Override
    public void modifyFleet(Fleet fleet) {
        fleetRepository.modifyFleet(fleet);
    }

    @Override
    public void addFleet(Fleet fleet) {
        fleetRepository.addFleet(fleet);
    }

    @Override
    public Integer getNumberOfDrivers(Integer fleetId) {
        return getNumberOfDrivers(fleetId);
    }
}
