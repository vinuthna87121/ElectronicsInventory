package com.ElectronicsInventory.electronics.inventory.controller;
import java.util.List;
import java.util.Map;

import com.ElectronicsInventory.electronics.inventory.entity.Electronics;
import com.ElectronicsInventory.electronics.inventory.repository.ElectronicsRepository;
import com.ElectronicsInventory.electronics.inventory.service.ElectronicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/electronics")
public class ElectronicsController {

    @Autowired
        ElectronicsService electronicsService;
    @Autowired
        ElectronicsRepository electronicsRepository;

        @GetMapping
        public ResponseEntity<List<Electronics>> getAll(){
            List<Electronics> result= electronicsService.getallElectronics();
            if(result != null){
                return ResponseEntity.ok(result);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }


        @GetMapping("/category/{category}")
        public ResponseEntity<List<Electronics>> findByCategory(@PathVariable  String category){
            List<Electronics> result=electronicsService.getByCategory(category);
            if(result != null) {
                return ResponseEntity.ok(result);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        @GetMapping ("/id/{id}")
        public ResponseEntity<Electronics> getById(@PathVariable Integer id){
            Electronics e = electronicsService.getProductById(id);

            if(e != null) {
                return ResponseEntity.ok(e);

            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        @PostMapping("/add")
        public ResponseEntity<Electronics> addElectronics(@RequestBody Electronics addelectronics ) {
            Electronics savedProduct =  electronicsService.createProduct(addelectronics);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Electronics> updateElectronics(@PathVariable Integer id, @RequestBody Electronics updateelectronics) {
            Electronics updatedProduct = electronicsService.updateProduct(id, updateelectronics);
            return ResponseEntity.ok(updatedProduct);
        }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteElectronics(@PathVariable Integer id) {
        electronicsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/addbulk")
    public ResponseEntity<List<Electronics>> addBulk(@RequestBody List<Electronics> electronics) {
        List<Electronics> savedProducts = electronicsService.addBulk(electronics);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducts);
    }

    @GetMapping("/groupByCategory")
    public ResponseEntity<Map<String, Long>> groupByCategory() {
        Map<String, Long> grouped = electronicsService.groupByCategory();
        return ResponseEntity.ok(grouped);
    }

}



