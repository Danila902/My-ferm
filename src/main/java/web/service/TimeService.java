package web.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import web.dto.TimeDTO;
import web.entity.Time;
import web.repository.TimeRepository;
import web.vo.TimeQueryVO;
import web.vo.TimeUpdateVO;
import web.vo.TimeVO;

import java.util.NoSuchElementException;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Long save(TimeVO vO) {
        Time bean = new Time();
        BeanUtils.copyProperties(vO, bean);
        bean = timeRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        timeRepository.deleteById(id);
    }

    public void update(Long id, TimeUpdateVO vO) {
        Time bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        timeRepository.save(bean);
    }

    public TimeDTO getById(Long id) {
        Time original = requireOne(id);
        return toDTO(original);
    }

    public Page<TimeDTO> query(TimeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TimeDTO toDTO(Time original) {
        TimeDTO bean = new TimeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Time requireOne(Long id) {
        return timeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
