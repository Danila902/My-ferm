package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import web.entity.Time;

public interface TimeRepository extends JpaRepository<Time, Long>, JpaSpecificationExecutor<Time> {

}