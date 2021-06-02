package com.example.PhoneAccessories.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<User> users;
}
