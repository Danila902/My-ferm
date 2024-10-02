package web.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import web.dto.PriceDTO;
import web.entity.Price;
import web.repository.PriceRepository;
import web.vo.PriceQueryVO;
import web.vo.PriceUpdateVO;
import web.vo.PriceVO;

import java.util.NoSuchElementException;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public Long save(PriceVO vO) {
        Price bean = new Price();
        BeanUtils.copyProperties(vO, bean);
        bean = priceRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        priceRepository.deleteById(id);
    }

    public void update(Long id, PriceUpdateVO vO) {
        Price bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        priceRepository.save(bean);
    }

    public PriceDTO getById(Long id) {
        Price original = requireOne(id);
        return toDTO(original);
    }

    public Page<PriceDTO> query(PriceQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PriceDTO toDTO(Price original) {
        PriceDTO bean = new PriceDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Price requireOne(Long id) {
        return priceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
