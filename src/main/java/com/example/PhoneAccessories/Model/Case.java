package com.example.PhoneAccessories.Model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cases")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NonNull
    private String name;
    @NonNull
    private Double price;
    @NonNull
    private Integer pcs;
    @NonNull
    private String description;
}
