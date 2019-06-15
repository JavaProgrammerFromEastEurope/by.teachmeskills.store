package entity;

import java.io.Serializable;
import java.util.Objects;

public class Discount implements Serializable {

    private int value;
    private String type;

    public Discount(String typeItem, int discount) {
        this.type = typeItem;
        this.value = discount;
    }

    public Discount(){}

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return value == discount1.value &&
                Objects.equals(type, discount1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }

    @Override
    public String toString() {
        return "Discount{" +
                "value=" + value +
                ", type='" + type + '\'' +
                '}';
    }
}
