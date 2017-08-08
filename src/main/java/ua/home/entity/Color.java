package ua.home.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String colorName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "color")
    private List<Product> productList;

    public Color() {
    }

    public Color(String colorName) {
        this.colorName = colorName;
    }

    public Color(String colorName, List<Product> productList) {
        this.colorName = colorName;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", colorName='" + colorName + '\'' +
                '}';
    }
}
