package application.actions.item;

import application.actions.Action;

public class UpdateItemAction extends BaseItemAction implements Action {

    @Override
    public String getName() {
        return "Редактирование товара";
    }

    @Override
    public void action() {
        itemController.updateObject();
    }
}