package com.example.PhoneAccessories.Controller;

import com.example.PhoneAccessories.Dto.CaseDto;
import com.example.PhoneAccessories.Model.Case;
import com.example.PhoneAccessories.Service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping(value = "items")
@RestController
public class CaseController {
    CaseService caseService;

    @Autowired
    CaseController(CaseService caseService) {
        this.caseService = caseService;
    }
    @GetMapping
    public Set<CaseDto> findAll() {
        return caseService.returnAllCases();
    }
    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody Case item) {
        caseService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
