package com.example.PhoneAccessories.Controller;

import com.example.PhoneAccessories.Model.Color;
import com.example.PhoneAccessories.Service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping(value = "colors")
@RestController
public class ColorController {

    ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save (@RequestBody Color color) {
        colorService.save(color);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public Set<Color> findAll() {
        return colorService.returnAllColors();
    }
}
