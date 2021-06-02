package com.example.PhoneAccessories.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String password;

        @Column(unique = true,nullable = false)
        private String username;

        @Column(unique = true,nullable = false)
        private String firstName;

        @Column(unique = true,nullable = false)
        private String lastName;

        @NotNull
        private Long age;

        @JsonBackReference
        @ManyToOne
        @JoinColumn(name = "role_id")
        private Role role;
}
