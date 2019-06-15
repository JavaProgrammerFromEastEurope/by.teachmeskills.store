package application.sortingMethods.discount;

import application.sortingMethods.SortTemplate;
import entity.Discount;

public class SortByValueDiscount implements SortTemplate<Discount> {

    @Override
    public int compare(Discount o1, Discount o2) {
        return o1.getValue() - o2.getValue();
    }

}