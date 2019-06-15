package application.actions.item;

import application.actions.Action;

public class XmlExportItemAction extends BaseItemAction implements Action, Runnable {


    @Override
    public void run() {
        itemController.xmlExportObject();
    }

    public String getName() {
        return "Экспортировать данные в XML файл";
    }

    @Override
    public void action() {
        Thread thread = new Thread(this, "XMLExportItemThread");
        thread.start();
    }
}