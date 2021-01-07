package org.exemple.firstspring;

import org.exemple.firstspring.dao.contracts.ContactDao;
import org.exemple.firstspring.dao.contracts.PersonDao;
import org.exemple.firstspring.dao.implementation.ContactFileDao;
import org.exemple.firstspring.dao.implementation.PersonFileDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {
    /*
        Имеется 2 текстовых файла, в первом хранится список имен в виде
        —————————————————————
        humans.txt
        —————————————————————
        Пупкин Василий Петрович 214739
        Иванов Иван Иванович 471104
        Петров Сергей Иванович 102507
        —————————————————————
        где последнее числа - уникальные идентификаторы пользователей

        Во втором - список контактов
        —————————————————————
        contacts.txt
        —————————————————————
        +380687747270 phone 214739
        vasia@gmail.com email 214739
        +380660002211 phone 471104
        —————————————————————

        phone, email - тип контакта
        число - идентификатор пользователя, которому пренадлежит контакт

        Реализовать меню со следующим функционалом:
        - Добавление человека в справочник контактов
        - Просмотр людей в справочнике
        - Удаление человека из справочника (должны удалится и все его контакты, (полное удаление васи вместе с его контактами))
        - Поиск человека по номеру телефона
        - Получение контактов человека
        - Добавление нового контакта
        - Удаление контакта (последний - это удалить один из контактов васи (например только телефон))

        Примечание:
        - В случае необходимости не должно возникнуть проблем с заменой хранилищ (сейчас-файлы, в перспективе может быть база....)
        - В данном случае при изменении данных (добавление/удаление), файлы должны меняться сразу
        - Стараться максимально руководствыватся принципами SOLID
        - Обратить внимание на то, что как-то надо генерировать случайный уникальный идентификатор при добавлении человека
    */


    final static String CONTACT_FILE_PATH = "C:/Users/Admin/Desktop/contacts.txt";
    final static String PERSON_FILE_PATH = "C:/Users/Admin/Desktop/humans.txt";

    public static void main(String[] args) throws IOException {
       /* ContactDao contactDao = new ContactFileDao(CONTACT_FILE_PATH);
        PersonDao personDao = new PersonFileDao(PERSON_FILE_PATH);
        AddressBook addressBook = new AddressBook(personDao, contactDao);
        Menu a = new Menu(addressBook);*/

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Menu menu = context.getBean(Menu.class);
        menu.showMenu();
    }
}






















