package com.example.PhoneAccessories.Dto;

import lombok.*;
import org.joda.money.Money;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseDto {

    private String header;
    private Money price;
    private Integer pcs;
}
