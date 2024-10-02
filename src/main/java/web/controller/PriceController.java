package web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.dto.PriceDTO;
import web.service.PriceService;
import web.vo.PriceQueryVO;
import web.vo.PriceUpdateVO;
import web.vo.PriceVO;

@Validated
@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping
    public String save(@Valid @RequestBody PriceVO vO) {
        return priceService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        priceService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PriceUpdateVO vO) {
        priceService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PriceDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return priceService.getById(id);
    }

    @GetMapping
    public Page<PriceDTO> query(@Valid PriceQueryVO vO) {
        return priceService.query(vO);
    }
}
