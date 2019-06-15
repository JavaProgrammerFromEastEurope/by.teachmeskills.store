package application.exceptions;

public class StopApplicationException extends Exception {

    public String getMessage() {
        return "Приложение закончило свою работу!";
    }
}
