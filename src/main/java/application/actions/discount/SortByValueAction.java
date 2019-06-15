package application.actions.discount;

import application.actions.Action;

public class SortByValueAction extends BaseDiscountAction implements Action {

    @Override
    public String getName() {
        return "Сортировка по значению";
    }

    @Override
    public void action() {
        discountController.sortByIntObject();
    }
}
