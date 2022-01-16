package com.example.demo.pojo.input;

public class EmployeesInput {

    private String name,surname;
    private String EMBG;

    public EmployeesInput() {
    }

    public EmployeesInput(String name, String surname, String EMBG) {
        this.name = name;
        this.surname = surname;
        this.EMBG = EMBG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEMBG() {
        return EMBG;
    }

    public void setEMBG(String EMBG) {
        this.EMBG = EMBG;
    }
}
