package org.exemple.firstspring.entities;



public class Person  {

    private String name;
    private String patronymic;
    private String surname;
    private Long id;

    public Person(String surname , String patronymic, String name) {
        this.surname = surname;
        this.patronymic = patronymic;
        this.name = name;
    }

    public Person(String surname, String name, String patronymic , Long id) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
