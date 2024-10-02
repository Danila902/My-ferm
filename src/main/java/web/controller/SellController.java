package web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.dto.SellDTO;
import web.service.SellService;
import web.vo.SellQueryVO;
import web.vo.SellUpdateVO;
import web.vo.SellVO;

@Validated
@RestController
@RequestMapping("/sell")
public class SellController {

    @Autowired
    private SellService sellService;

    @PostMapping
    public String save(@Valid @RequestBody SellVO vO) {
        return sellService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        sellService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody SellUpdateVO vO) {
        sellService.update(id, vO);
    }

    @GetMapping("/{id}")
    public SellDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return sellService.getById(id);
    }

    @GetMapping
    public Page<SellDTO> query(@Valid SellQueryVO vO) {
        return sellService.query(vO);
    }
}
