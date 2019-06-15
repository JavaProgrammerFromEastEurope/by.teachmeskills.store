package dao.Serializable;

import dao.DiscountDAO;
import entity.Discount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DiscountSerializableDAO implements DiscountDAO {
    private static final String PATH = "discounts.bin";

    @Override
    public List<Discount> get() {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(PATH))) {
            return (List<Discount>) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(List<Discount> discounts) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            stream.writeObject(discounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
