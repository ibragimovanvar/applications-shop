package model;

import java.util.List;

public class Basket {
    private static long counterId = 1;
    private Long id;
    private List<Product> products;
    private User owner;

    public Basket(List<Product> products, User owner) {
        this.id = counterId++;
        this.products = products;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
