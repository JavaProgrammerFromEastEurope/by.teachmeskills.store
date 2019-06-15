package dao.Serializable;

import dao.ItemDAO;
import entity.Item;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ItemSerializableDAO implements ItemDAO {
    private static final String PATH = "items.bin";

    @Override
    public List<Item> get() {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(PATH))) {
            return (List<Item>) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(List<Item> items) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            stream.writeObject(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}