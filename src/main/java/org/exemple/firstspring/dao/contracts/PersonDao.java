package org.exemple.firstspring.dao.contracts;

import org.exemple.firstspring.entities.Person;

import java.util.List;

public interface PersonDao {
    List<Person> getAll();
    void addPerson(Person p);
    void removePerson(Long id);
}
