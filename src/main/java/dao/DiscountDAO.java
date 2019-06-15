package dao;

import application.exceptions.discount.DuplicateDiscountException;
import application.exceptions.discount.NotFoundDiscountException;
import entity.Discount;

import java.util.List;

public interface DiscountDAO {

    List<Discount> get();

    default void add(Discount newDiscount) throws DuplicateDiscountException {
        List<Discount> discounts = get();
        for (Discount discount : discounts) {
            if (discount.getType().equals(newDiscount.getType())) {
                throw new DuplicateDiscountException(newDiscount.getType());
            }
        }
        discounts.add(newDiscount);
        save(discounts);
    }

    default void update(Discount newDiscount) throws NotFoundDiscountException {
        List<Discount> discounts = get();
        int index = 0;
        for (Discount discount : discounts) {
            if (discount.getType().equals(newDiscount.getType())) {
                discounts.set(index, newDiscount);
                save(discounts);
                return;
            }
            index++;
        }
        throw new NotFoundDiscountException(newDiscount.getType());
    }

    default void remove(String type) throws NotFoundDiscountException {
        List<Discount> discounts = get();
        for(Discount discount : discounts){
            if(discount.getType().equals(type)){
                discounts.remove(discount);
                save(discounts);
                return;
            }
        }
        throw new NotFoundDiscountException(type);
    }

    void save(List<Discount> discounts);
}