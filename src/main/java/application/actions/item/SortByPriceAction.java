package application.actions.item;

import application.actions.Action;

public class SortByPriceAction extends BaseItemAction implements Action {

    @Override
    public String getName() {
        return "Сортировка по цене";
    }

    @Override
    public void action() {
        itemController.sortByIntObject();
    }
}