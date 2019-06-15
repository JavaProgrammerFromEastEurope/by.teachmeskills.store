package application.exceptions.item;

public class DuplicateItemException extends Exception {

    private int id;

    public DuplicateItemException(int id) {
        this.id = id;
    }

    public String getMessage() {
        return String.format("Дубликат товара с id = %d", id);
    }
}