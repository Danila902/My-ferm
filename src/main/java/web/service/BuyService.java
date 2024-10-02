package web.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import web.dto.BuyDTO;
import web.entity.Buy;
import web.repository.BuyRepository;
import web.vo.BuyQueryVO;
import web.vo.BuyUpdateVO;
import web.vo.BuyVO;

import java.util.NoSuchElementException;

@Service
public class BuyService {

    @Autowired
    private BuyRepository buyRepository;

    public Long save(BuyVO vO) {
        Buy bean = new Buy();
        BeanUtils.copyProperties(vO, bean);
        bean = buyRepository.save(bean);
        return Long.valueOf(bean.getId());
    }

    public void delete(Long id) {
        buyRepository.deleteById(id);
    }

    public void update(Long id, BuyUpdateVO vO) {
        Buy bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        buyRepository.save(bean);
    }

    public BuyDTO getById(Long id) {
        Buy original = requireOne(id);
        return toDTO(original);
    }

    public Page<BuyDTO> query(BuyQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private BuyDTO toDTO(Buy original) {
        BuyDTO bean = new BuyDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Buy requireOne(Long id) {
        return buyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
