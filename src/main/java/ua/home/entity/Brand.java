package ua.home.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brandName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "brand")
    private List<Product> productList;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "brand")
    private List<BrandModel> brandModelList;

    public Brand() {
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Brand(String brandName, List<Product> productList) {
        this.brandName = brandName;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<BrandModel> getBrandModelList() {
        return brandModelList;
    }

    public void setBrandModelList(List<BrandModel> brandModelList) {
        this.brandModelList = brandModelList;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
