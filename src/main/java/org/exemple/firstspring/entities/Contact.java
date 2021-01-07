package org.exemple.firstspring.entities;


public class Contact {

    private String value;
    private String type;
    private Long id;

    public Contact(String value, String type, Long id) {
        this.value = value;
        this.type = type;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
