package com.example.PhoneAccessories.Controller;

import com.example.PhoneAccessories.Model.Role;
import com.example.PhoneAccessories.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "roles")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<Set<Role>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody Role role) {
        return ResponseEntity.ok(roleService.upgrade(id,role));
    }
}

