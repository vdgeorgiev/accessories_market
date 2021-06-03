package com.example.PhoneAccessories.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "type")
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String type; // Type item: case ,headphone, charger and other.

    @JsonManagedReference
    @OneToMany(mappedBy = "name" , cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Item> items;
}
