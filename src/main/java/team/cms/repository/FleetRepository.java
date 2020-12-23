package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team.cms.entity.Fleet;

import java.util.List;

@Mapper
@Repository
public interface FleetRepository {

    List<Fleet> getAll();

    Fleet getFleetById(Integer id);

    Integer getAmountOfFleet();

    void modifyFleet(Fleet fleet);

    Integer getNumberOfDrivers(Integer fleetId);

    void addFleet(Fleet fleet);
}
