package application.exceptions.discount;

public class NotFoundDiscountException extends Exception {

    private String typeItem;

    public NotFoundDiscountException(String typeItem) {
        this.typeItem = typeItem;
    }

    public String getMessage() {
        return String.format("Скидка с таким типом товара - %s не найдена!", typeItem);
    }
}