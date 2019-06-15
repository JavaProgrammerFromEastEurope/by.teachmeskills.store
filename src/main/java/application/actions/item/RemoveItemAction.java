package application.actions.item;

import application.actions.Action;

public class RemoveItemAction extends BaseItemAction implements Action {

    @Override
    public String getName() {
        return "Удаление товара";
    }

    @Override
    public void action() {
        itemController.removeObject();
    }
}