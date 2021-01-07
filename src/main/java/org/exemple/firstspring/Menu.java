package org.exemple.firstspring;

import org.exemple.firstspring.menu.menu_action.MenuAction;
//import com.company.my_contacts.menu.menu_implementation.*;
import org.exemple.firstspring.menu.menu_implementation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {
    private AddressBook addressBook;
    private List<MenuAction> menuActions;
    private Scanner scanner;
    private PrintStream out;

    @Autowired
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        this.menuActions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.out = System.out;
        menuActions.add(new AddingPersonContactsDirectory(addressBook, scanner, out));
        menuActions.add(new AddingNewContact(addressBook, scanner, out));
        menuActions.add(new CompleteRemoval(scanner, out, addressBook));
        menuActions.add(new DeletingSpecificTypeContact(scanner, out, addressBook));
        menuActions.add(new GettingPersonContacts(scanner, out, addressBook));
        menuActions.add(new SearchByNamePhoneNumber(scanner, out, addressBook));
        menuActions.add(new ViewingTheDirectory(scanner, out, addressBook));
        menuActions.add(new ExitMethod(out));
    }


    protected void show() {
        for (int i = 0; i < menuActions.size(); i++) {
            out.println((i + 1) + " ) " + menuActions.get(i).getActionName());
        }
    }

    protected int action() {
        out.println(" Введите номер запроса : ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showMenu() throws IOException {
        while (true) {
            show();
            int index = action() - 1;
            if (menuActions.size() > index && index >= 0) {
                menuActions.get(index).execute();
                if (menuActions.get(index).exitMethod()) break;
            }
        }
    }

}
