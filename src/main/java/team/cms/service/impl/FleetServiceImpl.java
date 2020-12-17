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
}
