package com.ElectronicsInventory.electronics.inventory.service;

import com.ElectronicsInventory.electronics.inventory.entity.Electronics;
import com.ElectronicsInventory.electronics.inventory.repository.ElectronicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElectronicsService {

    @Autowired
    ElectronicsRepository electronicsRepository;


    public List<Electronics> getByCategory(String category){
        return electronicsRepository.findByCategory(category);
    }


    public List<Electronics> getallElectronics(){
        return electronicsRepository.findAll();

    }
    public Electronics getProductById(Integer id){
        return electronicsRepository.findById(id).orElseThrow(() -> new RuntimeException("grocery not found"));
    }
    public Electronics getByName(String name) {
        return electronicsRepository.findByName(name);
    }
    public Electronics createProduct(Electronics addproduct) {
        return electronicsRepository.save(addproduct);
    }
    public Electronics updateProduct(Integer id,Electronics updateProduct) {
        Electronics existingProduct= electronicsRepository.findById(id).orElseThrow(()-> new RuntimeException("Electronic item  not found with ID: " + id));

        existingProduct.setName(updateProduct.getName());
        existingProduct.setTotalStock(updateProduct.getTotalStock());
        existingProduct.setActualPrice(updateProduct.getActualPrice());
        return electronicsRepository.save(existingProduct);
    }
    public void deleteById(Integer id) {
        electronicsRepository.deleteById(id);
    }
    public List<Electronics> addBulk(List<Electronics> electronics){
        return electronicsRepository.saveAll(electronics);

    }
    public Map<String,Long> groupByCategory(){
        List<Electronics> group= electronicsRepository.findAll();
        return group.stream()
                .collect(Collectors.groupingBy(Electronics :: getCategory, Collectors.counting()));

    }

    }
