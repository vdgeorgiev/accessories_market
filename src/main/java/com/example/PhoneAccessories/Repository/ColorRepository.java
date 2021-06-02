package com.example.PhoneAccessories.Repository;

import com.example.PhoneAccessories.Model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color,Long> {
}
