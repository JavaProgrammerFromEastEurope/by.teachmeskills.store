package dao;

import application.exceptions.item.DuplicateItemException;
import application.exceptions.item.NotFoundItemException;
import entity.Item;

import java.util.List;

public interface ItemDAO {

    List<Item> get();

    default void add(Item newItem) throws DuplicateItemException{
        List<Item> items = get();
        for (Item item : items) {
            if (item.getId() == newItem.getId()) {
                throw new DuplicateItemException(newItem.getId());
            }
        }
        items.add(newItem);
        save(items);
    }

    default void update(Item newItem) throws NotFoundItemException{
        List<Item> items = get();
        int index = 0;
        for (Item item : items) {
            if (item.getId() == newItem.getId()) {
                items.set(index, newItem);
                save(items);
                return;
            }
            index++;
        }
        throw new NotFoundItemException(newItem.getId());
    }

    default void remove(int id) throws NotFoundItemException {
        List<Item> items = get();
        for(Item item : items){
            if(item.getId() == id){
                items.remove(item);
                save(items);
                return;
            }
        }
        throw new NotFoundItemException(id);
    }

    void save(List<Item> items);
}