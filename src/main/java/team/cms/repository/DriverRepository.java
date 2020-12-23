package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.cms.entity.Driver;

import java.util.List;

@Mapper
@Repository
public interface DriverRepository {

    Driver getDriverByAccountId(Integer accountId);

    List<Driver> getFleetDrivers(Integer fleetId);

    void modifyDrivers(Driver driver);

    Driver getDriverById(Integer id);

    void addDriver(@Param("accountId")Integer accountId, @Param("fleetId")Integer fleetId);
}
