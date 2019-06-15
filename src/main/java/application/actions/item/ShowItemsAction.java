package application.actions.item;

import application.Application;
import application.actions.Action;
import application.exceptions.StopApplicationException;
import application.utils.Input;

import java.util.HashMap;
import java.util.Map;
import static java.lang.System.*;

public class ShowItemsAction extends BaseItemAction implements Action {

    private static HashMap<Integer, Action> sortActions = new HashMap<>();

    public ShowItemsAction() {
        sortActions.put(1, new SortByPriceAction());
        sortActions.put(2, new SortByNameAction());
    }

    @Override
    public String getName() {
        return "Показать все товары";
    }

    @Override
    public void action() {
        Action action = getSortAction();
        try {
            action.action();
        } catch (StopApplicationException ignored) {
        }
    }

    private Action getSortAction() {
        showSortMenu();
        int action = Input.getInt();
        if (sortActions.containsKey(action)) {
            return sortActions.get(action);
        } else {
            out.println("Переход в главное меню!");
        }
        return Application.getAction();
    }

    private void showSortMenu() {
        out.println("Выберете способ сортировки:");
        for (Map.Entry<Integer, Action> action : sortActions.entrySet()) {
            out.println(action.getKey() + " - " + action.getValue().getName());
        }
    }
}