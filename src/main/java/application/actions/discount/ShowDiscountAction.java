package application.actions.discount;

import application.Application;
import application.actions.Action;
import application.exceptions.StopApplicationException;
import application.utils.Input;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class ShowDiscountAction extends BaseDiscountAction implements Action  {

    private static HashMap<Integer, Action> sortActions = new HashMap<>();

    public ShowDiscountAction() {
        sortActions.put(1, new SortByValueAction());
        sortActions.put(2, new SortByTypeAction());
    }

    @Override
    public String getName() {
        return "Показать все скидки";
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