package web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.dto.WalletDTO;
import web.service.WalletService;
import web.vo.WalletQueryVO;
import web.vo.WalletUpdateVO;
import web.vo.WalletVO;

@Validated
@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public String save(@Valid @RequestBody WalletVO vO) {
        return walletService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        walletService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody WalletUpdateVO vO) {
        walletService.update(id, vO);
    }

    @GetMapping("/{id}")
    public WalletDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return walletService.getById(id);
    }

    @GetMapping
    public Page<WalletDTO> query(@Valid WalletQueryVO vO) {
        return walletService.query(vO);
    }
}
