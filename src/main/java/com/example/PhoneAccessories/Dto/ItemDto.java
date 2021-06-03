package com.example.PhoneAccessories.Dto;

import lombok.*;
import org.joda.money.Money;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private String header;
    private Money price;
    private Integer pcs;
}
