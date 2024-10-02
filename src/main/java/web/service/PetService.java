package web.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import web.dto.PetDTO;
import web.entity.Pet;
import web.repository.PetRepository;
import web.vo.PetQueryVO;
import web.vo.PetUpdateVO;
import web.vo.PetVO;

import java.util.NoSuchElementException;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Long save(PetVO vO) {
        Pet bean = new Pet();
        BeanUtils.copyProperties(vO, bean);
        bean = petRepository.save(bean);
        return Long.valueOf(bean.getId());
    }

    public void delete(Long id) {
        petRepository.deleteById(id);
    }

    public void update(Long id, PetUpdateVO vO) {
        Pet bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        petRepository.save(bean);
    }

    public PetDTO getById(Long id) {
        Pet original = requireOne(id);
        return toDTO(original);
    }

    public Page<PetDTO> query(PetQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PetDTO toDTO(Pet original) {
        PetDTO bean = new PetDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Pet requireOne(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
