package org.exemple.firstspring;

import org.exemple.firstspring.dao.implementation.ContactFileDao;
import org.exemple.firstspring.dao.implementation.PersonFileDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {


    private final static String CONTACT_PATH = "C:/Users/Admin/Desktop/contacts.txt";
    private final static String PERSON_PATH = "C:/Users/Admin/Desktop/humans.txt";


    @Bean
    public ContactFileDao contactFileDao() {
        return new ContactFileDao(CONTACT_PATH);

    }

    @Bean
    public PersonFileDao personFileDao() {
        return new PersonFileDao(PERSON_PATH);

    }

}
