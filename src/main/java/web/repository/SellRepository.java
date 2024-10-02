package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import web.entity.Sell;

@Component
public interface SellRepository extends JpaRepository<Sell, Long>, JpaSpecificationExecutor<Sell> {

}