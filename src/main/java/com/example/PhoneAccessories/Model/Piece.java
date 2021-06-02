package com.example.PhoneAccessories.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Embeddable
public class Piece {
    @Column(name = "pieces",nullable = false)
    private Integer pieces;
}
