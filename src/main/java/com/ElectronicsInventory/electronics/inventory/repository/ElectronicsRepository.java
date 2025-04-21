package com.ElectronicsInventory.electronics.inventory.repository;

import com.ElectronicsInventory.electronics.inventory.entity.Electronics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectronicsRepository extends JpaRepository<Electronics,Integer> {
    Electronics findByName(String name);
    List<Electronics> findByCategory(String category);

}
