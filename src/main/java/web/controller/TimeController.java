package web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.dto.TimeDTO;
import web.service.TimeService;
import web.vo.TimeQueryVO;
import web.vo.TimeUpdateVO;
import web.vo.TimeVO;

@Validated
@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @PostMapping
    public String save(@Valid @RequestBody TimeVO vO) {
        return timeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        timeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TimeUpdateVO vO) {
        timeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TimeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return timeService.getById(id);
    }

    @GetMapping
    public Page<TimeDTO> query(@Valid TimeQueryVO vO) {
        return timeService.query(vO);
    }
}
