package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import web.entity.Buy;

@Component
public interface BuyRepository extends JpaRepository<Buy, Long>, JpaSpecificationExecutor<Buy> {

}