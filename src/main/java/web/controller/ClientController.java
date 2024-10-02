package web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.dto.ClientDTO;
import web.service.ClientService;
import web.vo.ClientQueryVO;
import web.vo.ClientUpdateVO;
import web.vo.ClientVO;

@Validated
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public String save(@Valid @RequestBody ClientVO vO) {
        return clientService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        clientService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ClientUpdateVO vO) {
        clientService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ClientDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return clientService.getById(id);
    }

    @GetMapping
    public Page<ClientDTO> query(@Valid ClientQueryVO vO) {
        return clientService.query(vO);
    }
}
