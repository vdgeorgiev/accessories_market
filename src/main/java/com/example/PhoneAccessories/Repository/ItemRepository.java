package com.example.PhoneAccessories.Repository;

import com.example.PhoneAccessories.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    void deleteById(Long id);
}
