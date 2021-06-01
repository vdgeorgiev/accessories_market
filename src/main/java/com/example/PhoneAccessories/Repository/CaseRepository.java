package com.example.PhoneAccessories.Repository;

import com.example.PhoneAccessories.Model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
}
