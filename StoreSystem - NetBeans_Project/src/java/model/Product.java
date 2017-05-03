package model;

import java.util.Date;

public class Product {

    private int id;
    private String name;
    private Date date;
    private float price;
    private int stock;
    private String category;
    private String description;
    private String image_link;

    public Product(int id) {
        this.date = new Date();
        this.id = id;

    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", date=" + date + ", price=" + price + ", stock=" + stock + ", category=" + category + ", description=" + description + ", image_link=" + image_link + '}';
    }

 

}
