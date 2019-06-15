package application.actions.item;

import application.actions.Action;

public class AddItemAction extends BaseItemAction implements Action {

    @Override
    public String getName() {
        return "Добавление товара";
    }

    @Override
    public void action() {
        itemController.addObject();
    }
}