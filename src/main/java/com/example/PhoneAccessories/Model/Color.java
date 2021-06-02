package com.example.PhoneAccessories.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "colors")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true)
    private String color;

    @OneToMany(mappedBy = "color" , cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Case> cases;
}
