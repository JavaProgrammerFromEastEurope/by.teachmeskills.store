package application;

import application.actions.*;
import application.actions.discount.*;
import application.actions.item.*;
import application.exceptions.StopApplicationException;
import application.utils.Input;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class Application extends BaseItemAction {

    private static HashMap<Integer, Action> actions = new HashMap<>();

    public Application() {
        actions.put(0, new StopApplicationAction());
        actions.put(1, new ShowItemsAction());
        actions.put(2, new AddItemAction());
        actions.put(3, new UpdateItemAction());
        actions.put(4, new RemoveItemAction());
        actions.put(5, new XmlExportItemAction());
        actions.put(6, new ShowDiscountAction());
        actions.put(7, new AddDiscountAction());
        actions.put(8, new UpdateDiscountAction());
        actions.put(9, new RemoveDiscountAction());
        actions.put(10, new XmlExportDiscountAction());
    }

    public static void start() {
        out.println("Добро пожаловать!");
        run();
        out.println("Всего доброго!");
    }

    private static void run() {
        while (true) {
            Action action = getAction();
            try {
                action.action();
            } catch (StopApplicationException e) {
                break;
            }
        }
    }

    public static Action getAction() {
        showMenu();
        int action = Input.getInt();
        if (actions.containsKey(action)) {
            return actions.get(action);
        }
        out.println("Нет такого действия!");
        return getAction();
    }

    private static void showMenu() {
        out.println("Выберите действие:");
        for (Map.Entry<Integer, Action> action : actions.entrySet()) {
            out.println(action.getKey() + " - " + action.getValue().getName());
        }
    }
}