package com.example.PhoneAccessories.Dto;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseDto {

    private String name;
    private Double price;
    private Integer pcs;
}
