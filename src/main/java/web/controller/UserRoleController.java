package web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.dto.UserRoleDTO;
import web.service.UserRoleService;
import web.vo.UserRoleQueryVO;
import web.vo.UserRoleUpdateVO;
import web.vo.UserRoleVO;

@Validated
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping
    public String save(@Valid @RequestBody UserRoleVO vO) {
        return userRoleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        userRoleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UserRoleUpdateVO vO) {
        userRoleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserRoleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return userRoleService.getById(id);
    }

    @GetMapping
    public Page<UserRoleDTO> query(@Valid UserRoleQueryVO vO) {
        return userRoleService.query(vO);
    }
}
