package web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.dto.BuyDTO;
import web.service.BuyService;
import web.vo.BuyQueryVO;
import web.vo.BuyUpdateVO;
import web.vo.BuyVO;

@Validated
@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @PostMapping
    public String save(@Valid @RequestBody BuyVO vO) {
        return buyService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        buyService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody BuyUpdateVO vO) {
        buyService.update(id, vO);
    }

    @GetMapping("/{id}")
    public BuyDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return buyService.getById(id);
    }

    @GetMapping
    public Page<BuyDTO> query(@Valid BuyQueryVO vO) {
        return buyService.query(vO);
    }
}
