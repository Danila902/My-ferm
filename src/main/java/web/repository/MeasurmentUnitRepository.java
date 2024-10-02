package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import web.entity.MeasurmentUnit;

public interface MeasurmentUnitRepository extends JpaRepository<MeasurmentUnit, Long>, JpaSpecificationExecutor<MeasurmentUnit> {

}