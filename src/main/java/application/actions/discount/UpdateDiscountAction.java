package application.actions.discount;

import application.actions.Action;

public class UpdateDiscountAction extends BaseDiscountAction implements Action {

    @Override
    public String getName() {
        return "Редактирование скидки";
    }

    @Override
    public void action() {
        discountController.updateObject();
    }
}