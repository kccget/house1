package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {
    List<House> findByTitleContainingOrAddressContaining(String title, String address);
}
