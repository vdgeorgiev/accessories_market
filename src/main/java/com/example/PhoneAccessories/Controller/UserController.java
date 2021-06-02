package com.example.PhoneAccessories.Controller;

import com.example.PhoneAccessories.Dto.UserDto;
import com.example.PhoneAccessories.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Set<UserDto> findAll() {
        return userService.returnAllUsers();
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<UserDto> findUser(@PathVariable(value = "name") String username) {
        UserDto foundUser = userService.findByUsername(username);
        return ResponseEntity.ok(foundUser);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<HttpStatus> deleteByUsername(@PathVariable String username) {
        userService.deleteByUsername(username);
        return ResponseEntity.ok().build();
    }
}

