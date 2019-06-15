package application.actions.discount;

import application.actions.Action;


public class XmlExportDiscountAction extends BaseDiscountAction implements Action, Runnable {

    @Override
    public void run() {
        discountController.xmlExportObject();
    }

    public String getName() {
        return "Экспортировать скидки в XML файл";
    }

    @Override
    public void action() {
        Thread thread = new Thread(this, "XMLExportDiscountThread");
        thread.start();
    }
}
