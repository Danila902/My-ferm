package web.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import web.dto.ClientDTO;
import web.entity.Client;
import web.repository.ClientRepository;
import web.vo.ClientQueryVO;
import web.vo.ClientUpdateVO;
import web.vo.ClientVO;

import java.util.NoSuchElementException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Long save(ClientVO vO) {
        Client bean = new Client();
        BeanUtils.copyProperties(vO, bean);
        bean = clientRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public void update(Long id, ClientUpdateVO vO) {
        Client bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        clientRepository.save(bean);
    }

    public ClientDTO getById(Long id) {
        Client original = requireOne(id);
        return toDTO(original);
    }

    public Page<ClientDTO> query(ClientQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ClientDTO toDTO(Client original) {
        ClientDTO bean = new ClientDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Client requireOne(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
