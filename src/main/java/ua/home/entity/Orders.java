package ua.home.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_orders",
    joinColumns = @JoinColumn(name = "id_orders"),
    inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> productList;

    public Orders() {
        this.setStatus(Status.IN_CURT);
    }

    public Orders(User user) {
        this();
        this.user = user;
    }

    public Orders(List<Product> productList) {
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
