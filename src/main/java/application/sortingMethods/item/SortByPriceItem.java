package application.sortingMethods.item;

import application.sortingMethods.SortTemplate;
import entity.Item;

public class SortByPriceItem implements SortTemplate<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getPrice() - o2.getPrice();
    }
}