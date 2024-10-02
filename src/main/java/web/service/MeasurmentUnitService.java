package web.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import web.dto.MeasurmentUnitDTO;
import web.entity.MeasurmentUnit;
import web.repository.MeasurmentUnitRepository;
import web.vo.MeasurmentUnitQueryVO;
import web.vo.MeasurmentUnitUpdateVO;
import web.vo.MeasurmentUnitVO;

import java.util.NoSuchElementException;

@Service
public class MeasurmentUnitService {

    @Autowired
    private MeasurmentUnitRepository measurmentUnitRepository;

    public Long save(MeasurmentUnitVO vO) {
        MeasurmentUnit bean = new MeasurmentUnit();
        BeanUtils.copyProperties(vO, bean);
        bean = measurmentUnitRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        measurmentUnitRepository.deleteById(id);
    }

    public void update(Long id, MeasurmentUnitUpdateVO vO) {
        MeasurmentUnit bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        measurmentUnitRepository.save(bean);
    }

    public MeasurmentUnitDTO getById(Long id) {
        MeasurmentUnit original = requireOne(id);
        return toDTO(original);
    }

    public Page<MeasurmentUnitDTO> query(MeasurmentUnitQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MeasurmentUnitDTO toDTO(MeasurmentUnit original) {
        MeasurmentUnitDTO bean = new MeasurmentUnitDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MeasurmentUnit requireOne(Long id) {
        return measurmentUnitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
