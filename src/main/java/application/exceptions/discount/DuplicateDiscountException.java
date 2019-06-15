package application.exceptions.discount;

public class DuplicateDiscountException extends Exception {

    private String type;

    public DuplicateDiscountException(String type) {
        this.type = type;
    }

    public String getMessage() {
        return String.format("Дубликат скидки с таким типом = %s", type);
    }
}