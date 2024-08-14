package model;

public class Product {
    private static long counterId = 1;
    private long id;
    private String name;
    private int price;
    private User userOwner;
    private boolean active;


    public Product(String name, int price, User userOwner) {
        this.id = counterId++;
        this.name = name;
        this.price = price;
        this.userOwner = userOwner;
        this.active = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
