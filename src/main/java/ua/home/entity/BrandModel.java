package ua.home.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class BrandModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brandModelName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "brandModel")
    private List<Product> productList;

    public BrandModel() {
    }

    public BrandModel(String brandModelName) {
        this.brandModelName = brandModelName;
    }

    public BrandModel(String brandModelName, Brand brand) {
        this.brandModelName = brandModelName;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandModelName() {
        return brandModelName;
    }

    public void setBrandModelName(String brandModelName) {
        this.brandModelName = brandModelName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "BrandModel{" +
                "id=" + id +
                ", brandModelName='" + brandModelName + '\'' +
                '}';
    }
}
