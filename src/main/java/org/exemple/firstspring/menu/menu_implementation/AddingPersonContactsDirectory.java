package org.exemple.firstspring.menu.menu_implementation;

import org.exemple.firstspring.AddressBook;
import org.exemple.firstspring.menu.menu_action.MenuAction;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class AddingPersonContactsDirectory implements MenuAction {

    private AddressBook addressBook;
    private String name;
    private Scanner scanner;
    private PrintStream out;

    public AddingPersonContactsDirectory(AddressBook addressBook, Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
        this.addressBook = addressBook;
        this.name = " Добавление человека в справочник контактов";
    }

    @Override
    public String getActionName() {
        return name;
    }

    @Override
    public void execute() throws IOException {
        out.println(" Введите фамилию :");
        String surname = scanner.nextLine();
        out.println(" Введите имя : ");
        String name = scanner.nextLine();
        out.println(" Введите отчество : ");
        String patronymic = scanner.nextLine();
    addressBook.addPerson(surname,name,patronymic);
    }

    @Override
    public boolean exitMethod() {
        return false;
    }

}
