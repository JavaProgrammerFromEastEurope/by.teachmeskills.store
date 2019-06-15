package application.actions.discount;

import application.actions.Action;

public class SortByTypeAction extends BaseDiscountAction implements Action  {

    @Override
    public String getName() {
        return "Сортировка по типу";
    }

    @Override
    public void action() {
        discountController.sortByStringObject();
    }
}
