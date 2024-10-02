package web.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import web.dto.SellDTO;
import web.entity.Sell;
import web.repository.SellRepository;
import web.vo.SellQueryVO;
import web.vo.SellUpdateVO;
import web.vo.SellVO;

import java.util.NoSuchElementException;

@Service
public class SellService {

    @Autowired
    private SellRepository sellRepository;

    public Long save(SellVO vO) {
        Sell bean = new Sell();
        BeanUtils.copyProperties(vO, bean);
        bean = sellRepository.save(bean);
        return Long.valueOf(bean.getId());
    }

    public void delete(Long id) {
        sellRepository.deleteById(id);
    }

    public void update(Long id, SellUpdateVO vO) {
        Sell bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        sellRepository.save(bean);
    }

    public SellDTO getById(Long id) {
        Sell original = requireOne(id);
        return toDTO(original);
    }

    public Page<SellDTO> query(SellQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SellDTO toDTO(Sell original) {
        SellDTO bean = new SellDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Sell requireOne(Long id) {
        return sellRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
