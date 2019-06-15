package application.actions;

import application.exceptions.StopApplicationException;

public interface Action {
    String getName();
    void action() throws StopApplicationException;
}