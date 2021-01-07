package org.exemple.firstspring;


/*   Реализовать меню со следующим функционалом:
        - Добавление человека в справочник контактов
        - Просмотр людей в справочнике
        - Удаление человека из справочника (должны удалится и все его контакты, (полное удаление васи вместе с его контактами))
        - Поиск человека по номеру телефона
        - Получение контактов человека
        - Добавление нового контакта
        - Удаление контакта (последний - это удалить один из контактов васи (например только телефон))*/


import org.exemple.firstspring.dao.contracts.ContactDao;
import org.exemple.firstspring.dao.contracts.PersonDao;
import org.exemple.firstspring.entities.Contact;
import org.exemple.firstspring.entities.Person;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
public class AddressBook {
    private PersonDao personDao;
    private ContactDao contactsDao;


    public AddressBook(PersonDao personDao, ContactDao contactsDao) {
        this.personDao = personDao;
        this.contactsDao = contactsDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public ContactDao getContactsDao() {
        return contactsDao;
    }

    /**
     * получить Id по номеру в списке
     *
     * @return
     */

    private Long getIdOfPerson(int number) {
        number = number - 1;
        Long res = 0L;
        List<Person> buf = getPersonDao().getAll();
        for (int i = 0; i < buf.size(); i++) {
            if (number == i) res = buf.get(i).getId();
        }
        return res;
    }

    /**
     * Добавление человека в справочник контактов
     */

    public void addPerson(String surname, String patronymic, String name) {
        personDao.addPerson(new Person(surname,name ,patronymic ));
    }

    /**
     * Просмотр людей в справочнике
     */

    public List<Person> showDirectory() {
        List<Person> per = getPersonDao().getAll();
        return per;
    }

    /**
     * - Добавление нового контакта
     */

    public void addContact(int number, String value, String type) {
        Long num = getIdOfPerson(number);
        List<Contact> arr = getContactsDao().getAllContact();
        contactsDao.addPersonContact(new Contact(value, type, num));
    }

    /**
     * - Получение контактов человека
     *
     * @return
     */

    public List<Contact> getInformationAboutPerson(int number) {
        Long num = getIdOfPerson(number);
        List<Contact> res = new ArrayList<>();
        List<Contact> buf = getContactsDao().getAllContact();
        for (Contact contact : buf) {
            if (num.equals(contact.getId())) {
                res.add(contact);
            }
        }

        return res;
    }

    /**
     * Удаление человека из справочника
     */

    public void deletingPersonAndContact(int serialNumber) {
        Long id = getIdOfPerson(serialNumber);
        personDao.removePerson(id);
        contactsDao.removePersonContact(id);
    }

    /**
     * Поиск человека по номеру телефона
     *
     * @return
     */

    public String searchByPhoneNumber(String number) {
        List<Contact> arr = contactsDao.getAllContact();
        List<Person> arr2 = personDao.getAll();
        Long id = 0L;
        String res = null;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getValue().equals(number)) {
                id = arr.get(i).getId();
            }
        }
        for (int i = 0; i < arr2.size(); i++) {
            if (arr2.get(i).getId().equals(id)) {
                res = arr2.get(i).getSurname() + " " + arr2.get(i).getName() + " " + arr2.get(i).getPatronymic();
            }
        }
        return res;
    }

    /**
     * Удаление контакта ( определенного (например только телефон))
     */

    public void deletingAnIndividualContact(int serialNumber, String value) {
        List<Contact> arr = contactsDao.getAllContact();
        Long id = getIdOfPerson(serialNumber);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getId().equals(id)) {
                contactsDao.removeAnIndividualContact(value);
            }
        }
    }

}
