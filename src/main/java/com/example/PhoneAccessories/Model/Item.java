package com.example.PhoneAccessories.Model;

import com.example.PhoneAccessories.Converter.MoneyConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.joda.money.Money;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NonNull
    private String header;

    @Convert(converter = MoneyConverter.class)
    @NonNull
    private Money price;

    @Embedded
    private Piece piece;

    @NonNull
    private String description;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "type_id")
    private ItemType type;
}
