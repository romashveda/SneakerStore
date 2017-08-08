package ua.home.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sizeNum;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "size")
    private List<Product> productList;

    public Size() {
    }

    public Size(String sizeNum) {
        this.sizeNum = sizeNum;
    }

    public Size(String sizeNum, List<Product> productList) {
        this.sizeNum = sizeNum;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeNum() {
        return sizeNum;
    }

    public void setSizeNum(String sizeNum) {
        this.sizeNum = sizeNum;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", sizeNum=" + sizeNum +
                '}';
    }
}
