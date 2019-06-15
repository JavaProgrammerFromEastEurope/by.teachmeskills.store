package application.actions.item;

import application.actions.Action;

public class SortByNameAction extends BaseItemAction implements Action {

    @Override
    public String getName() {
        return "Сортировка по имени";
    }

    @Override
    public void action() {
        itemController.sortByStringObject();
    }
}