package org.exemple.firstspring.dao.implementation;

import org.exemple.firstspring.dao.contracts.ContactDao;
import org.exemple.firstspring.entities.Contact;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactFileDao implements ContactDao {

    private String contactPath;

    public ContactFileDao(String contactPath) {
        this.contactPath = contactPath;
    }


    @Override
    public List<Contact> getAllContact() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(contactPath)) {
            Scanner sc = new Scanner(fileInputStream);
            while (sc.hasNextLine()) {
                String value = sc.next();
                String type = sc.next();
                Long id = sc.nextLong();
                if (sc.hasNextLine()) sc.nextLine();
                contacts.add(new Contact(value, type, id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public void addPersonContact(Contact contact) {
        List<Contact> contacts = getAllContact();
        contacts.add(contact);
        saveContact(contacts);
    }

    public void saveContact(List<Contact> contacts) {
        try (FileOutputStream out = new FileOutputStream(contactPath)) {
            PrintWriter writer = new PrintWriter(out);
            for (Contact contact : contacts) {
                writer.println(contact.getValue() + " " + contact.getType() + " " + contact.getId());
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void removePersonContact(Long id) {
        List<Contact> contacts = getAllContact();
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts){
            if (contact.getId().equals(id)) continue;
            result.add(contact);
        }
        saveContact(result);
    }

    @Override
    public void removeAnIndividualContact(String value) {
        List<Contact> contacts = getAllContact();
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts){
            if (contact.getValue().equals(value)) continue;
            result.add(contact);
        }
        saveContact(result);
    }


}
