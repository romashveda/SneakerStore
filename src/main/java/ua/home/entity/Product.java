package ua.home.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String price;
    private boolean onSale;
    private String avatar;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
    private BrandModel brandModel;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sex sex;
    @ManyToOne(fetch = FetchType.LAZY)
    private Size size;
    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_orders",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_orders"))
    private List<Orders> ordersList;

    public Product() {
    }

    public Product(String model, String price, boolean onSale, String avatar) {
        this.model = model;
        this.price = price;
        this.onSale = onSale;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public BrandModel getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(BrandModel brandModel) {
        this.brandModel = brandModel;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }


    @Override
    public String toString() {
        return  model + " "+ brand +" "+brandModel+" "+category+" "+sex+" "+color +'}';


    }
}
