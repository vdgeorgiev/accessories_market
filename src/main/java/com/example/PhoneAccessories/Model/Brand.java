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
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "name" , cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Case> cases;
}
