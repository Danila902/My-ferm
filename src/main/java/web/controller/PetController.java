package web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.dto.PetDTO;
import web.service.PetService;
import web.vo.PetQueryVO;
import web.vo.PetUpdateVO;
import web.vo.PetVO;

@Validated
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public String save(@Valid @RequestBody PetVO vO) {
        return petService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        petService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PetUpdateVO vO) {
        petService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PetDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return petService.getById(id);
    }

    @GetMapping
    public Page<PetDTO> query(@Valid PetQueryVO vO) {
        return petService.query(vO);
    }
}
