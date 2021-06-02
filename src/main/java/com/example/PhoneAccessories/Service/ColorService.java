package com.example.PhoneAccessories.Service;

import com.example.PhoneAccessories.Dto.CaseDto;
import com.example.PhoneAccessories.Model.Case;
import com.example.PhoneAccessories.Model.Color;
import com.example.PhoneAccessories.Repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ColorService {
    ColorRepository colorRepository;

    @Autowired
    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }
    public void save(@NotNull Color color) {
        colorRepository.save(color);
    }
    public Set<Color> returnAllColors() {
        return colorRepository.findAll().stream().collect(Collectors.toSet());
    }
}
