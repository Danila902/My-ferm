package web.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import web.dto.UserRoleDTO;
import web.entity.UserRole;
import web.repository.UserRoleRepository;
import web.vo.UserRoleQueryVO;
import web.vo.UserRoleUpdateVO;
import web.vo.UserRoleVO;

import java.util.NoSuchElementException;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public Long save(UserRoleVO vO) {
        UserRole bean = new UserRole();
        BeanUtils.copyProperties(vO, bean);
        bean = userRoleRepository.save(bean);
        return Long.valueOf(bean.getId());
    }

    public void delete(Long id) {
        userRoleRepository.deleteById(id);
    }

    public void update(Long id, UserRoleUpdateVO vO) {
        UserRole bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userRoleRepository.save(bean);
    }

    public UserRoleDTO getById(Long id) {
        UserRole original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserRoleDTO> query(UserRoleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserRoleDTO toDTO(UserRole original) {
        UserRoleDTO bean = new UserRoleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserRole requireOne(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
