package controllers;

import application.exceptions.discount.*;
import application.sortingMethods.discount.*;
import application.utils.Input;
import dao.Serializable.DiscountSerializableDAO;
import dao.XML.DiscountXMLDAO;
import entity.Discount;
import java.util.List;

import static java.lang.System.out;

public class DiscountController implements ControllerTemplate {

    private static DiscountSerializableDAO discountSerializableDAO = new DiscountSerializableDAO();
    private static DiscountXMLDAO discountXMLDAO = new DiscountXMLDAO();

    private static final String PATH = "discounts.xml";

    private static Discount inputDiscountObject() {
        String type = Input.getString("Введите тип товара:");
        int value = Input.getInt("Введите значение скидки:");
        return new Discount(type, value);
    }

    @Override
    public void addObject() {
        try {
            discountSerializableDAO.add(inputDiscountObject());
            //discountXMLDAO.add(inputDiscountObject());
            out.println("Добавление скидки произошло успешно!");
        } catch (DuplicateDiscountException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateObject() {
        try {
            discountSerializableDAO.update(inputDiscountObject());
            //discountXMLDAO.update(inputDiscountObject());
            out.println("Обновление скидки произошло успешно!");
        } catch (NotFoundDiscountException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeObject() {
        String type = Input.getString("Введите тип скидки");
        try {
            discountSerializableDAO.remove(type);
            //discountXMLDAO.remove(type);
            out.println("Удаление скидки произошло успешно!");
        } catch (NotFoundDiscountException e) {
            out.println(e.getMessage());
        }
    }

    @Override
    public void sortByStringObject() {
        List<Discount> discounts = discountSerializableDAO.get();
        discounts.sort(new SortByTypeDiscount());

        for (Discount discount : discounts) {
            out.println(discount);
        }
        if (discounts.size()==0){
            out.println("Список скидок пуст!");
        }
    }

    @Override
    public void sortByIntObject() {
        List<Discount> discounts = discountSerializableDAO.get();
        discounts.sort(new SortByValueDiscount());

        for (Discount discount : discounts) {
            out.println(discount);
        }
        if (discounts.size()==0){
            out.println("Список скидок пуст!");
        }
    }

    @Override
    public void xmlExportObject() {
        discountXMLDAO.save(discountSerializableDAO.get());
        out.println("Скидки успешно экспортированы!");
    }
}