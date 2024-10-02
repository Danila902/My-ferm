package web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.dto.MeasurmentUnitDTO;
import web.service.MeasurmentUnitService;
import web.vo.MeasurmentUnitQueryVO;
import web.vo.MeasurmentUnitUpdateVO;
import web.vo.MeasurmentUnitVO;

@Validated
@RestController
@RequestMapping("/measurmentUnit")
public class MeasurmentUnitController {

    @Autowired
    private MeasurmentUnitService measurmentUnitService;

    @PostMapping
    public String save(@Valid @RequestBody MeasurmentUnitVO vO) {
        return measurmentUnitService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        measurmentUnitService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MeasurmentUnitUpdateVO vO) {
        measurmentUnitService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MeasurmentUnitDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return measurmentUnitService.getById(id);
    }

    @GetMapping
    public Page<MeasurmentUnitDTO> query(@Valid MeasurmentUnitQueryVO vO) {
        return measurmentUnitService.query(vO);
    }
}
