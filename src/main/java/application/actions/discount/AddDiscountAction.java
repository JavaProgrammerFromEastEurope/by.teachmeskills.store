package application.actions.discount;

import application.actions.Action;

public class AddDiscountAction extends BaseDiscountAction implements Action {

    @Override
    public String getName() {
        return "Добавление скидки";
    }

    @Override
    public void action() {
        discountController.addObject();
    }
}