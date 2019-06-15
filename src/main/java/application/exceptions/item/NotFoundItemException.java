package application.exceptions.item;

public class NotFoundItemException extends Exception {

    private int id;

    public NotFoundItemException(int id) {
        this.id = id;
    }

    public String getMessage() {
        return String.format("Товар с id = %d не найден!", id);
    }
}