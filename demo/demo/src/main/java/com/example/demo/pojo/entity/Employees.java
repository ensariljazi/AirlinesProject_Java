package com.example.demo.pojo.entity;

import com.example.demo.AgeExeption;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column (name = "name")
    private  String name;

    @Column(name = "surname")
    private String surname;

    @Column (name="age")
    private Integer age;

    @Column(name = "embg")
    private String embg;


    @ManyToOne
    @JoinColumn(name="works_at")
    @JsonBackReference
    private Agencies agencies;


    public Employees() {
    }

    public Employees(int id, String name, String surname, String embg,int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.embg = embg;
        this.age=age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmbg() {
        return embg;
    }

    public void setEmbg(String embg) {
        this.embg = embg;
    }

    public void AgeTest(Integer age) throws AgeExeption {
        if(age < 18){
            throw new AgeExeption();
        }
    }
}
