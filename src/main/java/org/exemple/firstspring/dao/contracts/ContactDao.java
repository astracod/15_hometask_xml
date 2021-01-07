package org.exemple.firstspring.dao.contracts;

import org.exemple.firstspring.entities.Contact;

import java.util.List;

public interface ContactDao {

    List<Contact> getAllContact();
    void addPersonContact(Contact contact);
    void removePersonContact(Long id);
    void removeAnIndividualContact(String value);
}
