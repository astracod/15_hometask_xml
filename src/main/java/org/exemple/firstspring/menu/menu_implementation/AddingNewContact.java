package org.exemple.firstspring.menu.menu_implementation;

import org.exemple.firstspring.AddressBook;
import org.exemple.firstspring.menu.menu_action.MenuAction;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class AddingNewContact implements MenuAction {

    private AddressBook addressBook;
    private Scanner scanner;
    private PrintStream out;
    private String name;

    public AddingNewContact(AddressBook addressBook, Scanner scanner, PrintStream out) {
        this.addressBook = addressBook;
        this.scanner = scanner;
        this.out = out;
        this.name = " Добавление нового контакта";
    }

    @Override
    public String getActionName() {
        return name;
    }

    @Override
    public void execute() throws IOException {
        out.println(" Введите порядковый номер абонента");
        int number = Integer.parseInt(scanner.nextLine());
        out.println(" Введите сохраняемую информацию");
        String value = scanner.nextLine();
        out.println(" Введите тип сохраняемой информации");
        String type = scanner.nextLine();
        addressBook.addContact(number,value,type);
    }

    @Override
    public boolean exitMethod() {
        return false;
    }
}
