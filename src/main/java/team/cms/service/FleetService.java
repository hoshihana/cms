package team.cms.service;

import team.cms.entity.Fleet;

import java.util.List;

public interface FleetService {

    List<Fleet>  getAll();

    Fleet getFleetById(Integer id);

}
