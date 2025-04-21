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
        public List<Electronics> getAll(){
            return electronicsService.getallElectronics();
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
        public Electronics addElectronics(@RequestBody Electronics addelectronics ) {
            return electronicsService.createProduct(addelectronics);
        }
        @PutMapping("/update/{id}")
        public Electronics updateElectronics(@PathVariable Integer id, @RequestBody Electronics updateelectronics ) {
            return electronicsService.updateProduct(id,updateelectronics);

        }
        @DeleteMapping("/delete/{id}")
        public void deleteElectronics(@PathVariable Integer id) {
            electronicsService.deleteById(id);

        }
        @PostMapping("/addbulk")
        public List<Electronics> addBulk(@RequestBody List<Electronics> electronics){
            return electronicsService.addBulk(electronics);

        }
        @GetMapping("/groupByCategory")
        public Map<String,Long> groupByCategory(){
            return electronicsService.groupByCategory();
        }
    }



