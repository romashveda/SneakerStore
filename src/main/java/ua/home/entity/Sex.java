package ua.home.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sexName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "sex")
    private List<Product> productList;

    public Sex() {
    }

    public Sex(String sexName) {
        this.sexName = sexName;
    }

    public Sex(String sexName, List<Product> productList) {
        this.sexName = sexName;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "id=" + id +
                ", sexName='" + sexName + '\'' +
                '}';
    }
}

