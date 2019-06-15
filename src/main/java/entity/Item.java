package entity;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int price;
    private String type;
    private String name;

    public Item(int id, int price, String type, String name) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.name = name;
    }

    public Item(int id) {
        this.id = id;
    }

    public Item() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                price == item.price &&
                Objects.equals(type, item.type) &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, type, name);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}