package application.actions.discount;

import application.actions.Action;

public class RemoveDiscountAction extends BaseDiscountAction implements Action  {

    @Override
    public String getName() {
        return "Удаление скидки";
    }

    @Override
    public void action() {
        discountController.removeObject();
    }
}