package org.exemple.firstspring;

import org.exemple.firstspring.dao.implementation.ContactFileDao;
import org.exemple.firstspring.dao.implementation.PersonFileDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {


    private String contactPath = "C:/Users/Admin/Desktop/contacts.txt";
    private String personPath = "C:/Users/Admin/Desktop/humans.txt";


    @Bean
    public ContactFileDao contactFileDao() {
        ContactFileDao contactFileDao = new ContactFileDao(contactPath);
        return contactFileDao;
    }

    @Bean
    public PersonFileDao personFileDao() {
        PersonFileDao personFileDao = new PersonFileDao(personPath);
        return personFileDao;
    }

}
