package org.exemple.firstspring.menu.menu_action;

import java.io.IOException;

public interface MenuAction {
    String getActionName();
    void execute() throws IOException;
    boolean exitMethod();
}
