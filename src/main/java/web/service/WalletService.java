package web.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import web.dto.WalletDTO;
import web.entity.Wallet;
import web.repository.WalletRepository;
import web.vo.WalletQueryVO;
import web.vo.WalletUpdateVO;
import web.vo.WalletVO;

import java.util.NoSuchElementException;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Long save(WalletVO vO) {
        Wallet bean = new Wallet();
        BeanUtils.copyProperties(vO, bean);
        bean = walletRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        walletRepository.deleteById(id);
    }

    public void update(Long id, WalletUpdateVO vO) {
        Wallet bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        walletRepository.save(bean);
    }

    public WalletDTO getById(Long id) {
        Wallet original = requireOne(id);
        return toDTO(original);
    }

    public Page<WalletDTO> query(WalletQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private WalletDTO toDTO(Wallet original) {
        WalletDTO bean = new WalletDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Wallet requireOne(Long id) {
        return walletRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
