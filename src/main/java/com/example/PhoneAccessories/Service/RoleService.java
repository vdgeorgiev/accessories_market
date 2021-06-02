package com.example.PhoneAccessories.Service;

import com.example.PhoneAccessories.Model.Role;
import com.example.PhoneAccessories.Repository.RoleRepository;
import com.example.PhoneAccessories.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Set<Role> findAll(){
        return roleRepository.findAll().stream().collect(Collectors.toSet());
    }

    public void save(@NotNull Role role) {
        roleRepository.save(role);
    }

    public Role findById(@NotNull Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Role findByName(@NotNull String roleName) {
        return roleRepository.findByName(roleName).orElseThrow(() -> new IllegalArgumentException());
    }

    public Role upgrade(Long id, Role role) {
        Role foundRole = roleRepository.findById(id).orElseThrow(()
                -> new NotFoundException(String.format("Role with is %s",id)));
        foundRole.setName(role.getName());
        return roleRepository.save(foundRole);
    }
}

