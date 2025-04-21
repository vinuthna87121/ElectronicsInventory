package com.ElectronicsInventory.electronics.inventory.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Electronics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String category;
    @Column(nullable=false)
    private float actualPrice;
    @Column(nullable=false)
    private float discountedPrice;
    @Column(nullable=false)
    private int totalStock;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return id == that.id && Float.compare(actualPrice, that.actualPrice) == 0 && Float.compare(discountedPrice, that.discountedPrice) == 0 && totalStock == that.totalStock && Objects.equals(name, that.name) && Objects.equals(category, that.category);
    }

    public Electronics() {
        super();
    }

    public Electronics(int id) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.actualPrice = actualPrice;
        this.discountedPrice = discountedPrice;
        this.totalStock = totalStock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, actualPrice, discountedPrice, totalStock);
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public float getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(float discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public float getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(float actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
