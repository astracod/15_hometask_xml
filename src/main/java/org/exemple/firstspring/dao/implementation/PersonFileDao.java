package org.exemple.firstspring.dao.implementation;

import org.exemple.firstspring.dao.contracts.PersonDao;
import org.exemple.firstspring.entities.Person;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PersonFileDao implements PersonDao {

    private String path;

    public PersonFileDao(String path) {
        this.path = path;
    }

    @Override
    public List<Person> getAll() {
        ArrayList<Person> persons = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path);) {
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {
                String surname = sc.next();
                String name = sc.next();
                String patronymic = sc.next();
                Long id = sc.nextLong();
                if (sc.hasNextLine()) sc.nextLine();
                persons.add(new Person(surname, name, patronymic, id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    private long newPersonId(List<Person> people) {
        long id = 1;
        if (people.size() > 0) {
            long maxId = people.get(0).getId();
            for (Person person : people) {
                if (person.getId() > maxId) maxId = person.getId();
            }
            id = maxId + 1;
        }
        return id;
    }

    @Override
    public void addPerson(Person p) {
        List<Person> people = getAll();
        long id = newPersonId(people);
        p.setId(id);
        people.add(p);
        savePerson(people);
    }

    private void savePerson(List<Person> peoples) {
        try (FileOutputStream out = new FileOutputStream(path)) {
            PrintWriter writer = new PrintWriter(out);
            for (Person person : peoples) {
                writer.println(person.getSurname() +" "+ person.getName() +" "+ person.getPatronymic() +" "+ person.getId());
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removePerson(Long id) {
        List<Person> people = getAll();
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.getId().equals(id)) continue;
            result.add(person);
        }
        savePerson(result);
    }
}
