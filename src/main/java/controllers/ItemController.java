package controllers;

import application.exceptions.item.*;
import application.sortingMethods.item.*;
import application.utils.Input;
import dao.Serializable.DiscountSerializableDAO;
import dao.Serializable.ItemSerializableDAO;
import dao.XML.ItemXMLDAO;
import entity.Discount;
import entity.Item;

import java.util.List;

import static java.lang.System.out;

public class ItemController implements ControllerTemplate {

    private static ItemSerializableDAO itemSerializableDAO = new ItemSerializableDAO();
    private static DiscountSerializableDAO discountSerializableDAO = new DiscountSerializableDAO();
    private static ItemXMLDAO itemXMLDAO = new ItemXMLDAO();

    private static Item inputItemObject() {
        int id = Input.getInt("Введите id");
        int price = Input.getInt("Введите цену");
        String type = Input.getString("Введите тип");
        String name = Input.getString("Введите название");
        return new Item(id, price, type, name);
    }

    private static Item changePrice(Item item){
        List<Discount> discounts = discountSerializableDAO.get();
        int tempPrice = item.getPrice();
        String type = item.getType();

        for (Discount discount : discounts){
            if(discount.getType().equals(type)){
                tempPrice = tempPrice - tempPrice * discount.getValue() / 100;
                item.setPrice(tempPrice);
                out.printf("Скидка на товар - %s составляет - %d%%%n" +
                        "данные товара с учетом скидки составляют: %n%s%n",
                        discount.getType(), discount.getValue(), item);
                return item;
            }
        }
        return item;
    }
    @Override
    public void addObject() {
        try {
            itemSerializableDAO.add(changePrice(inputItemObject()));
            //itemXMLDAO.add(inputItemObject());
            out.println("Добавление товара произошло успешно!");
        } catch (DuplicateItemException e) {
            out.println(e.getMessage());
        }
    }

    @Override
    public void updateObject() {
        try {
            itemSerializableDAO.update(changePrice(inputItemObject()));
            //itemXMLDAO.update(inputItemObject());
            out.println("Обновление товара произошло успешно!");
        } catch (NotFoundItemException e) {
            out.println(e.getMessage());
        }
    }

    @Override
    public void removeObject() {
        int id = Input.getInt("Введите id удаляемого товара:");
        try {
            itemSerializableDAO.remove(id);
            //itemXMLDAO.remove(id);
            out.println("Удаление товара произошло успешно!");
        } catch (NotFoundItemException e) {
            out.println(e.getMessage());
        }
    }

    @Override
    public void sortByStringObject() {
        List<Item> items = itemSerializableDAO.get();
        //List<Item> items = itemXMLDAO.get();
        items.sort(new SortByNameItem());

        for (Item item : items) {
            out.println(item);
        }
        if (items.size()==0){
            out.println("Список товаров пуст!");
        }
    }

    @Override
    public void sortByIntObject() {
        List<Item> items = itemSerializableDAO.get();
        //List<Item> items = itemXMLDAO.get();
        items.sort(new SortByPriceItem());

        for (Item item : items) {
            out.println(item);
        }
        if (items.size()==0){
            out.println("Список товаров пуст!");
        }
    }

    @Override
    public void xmlExportObject() {
        itemXMLDAO.save(itemSerializableDAO.get());
        out.println("Экспортирование данных произошло успешно!");
    }
}