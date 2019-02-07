package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "developer.getAll", query = "SELECT p FROM Developer p"),
        @NamedQuery(name = "developer.getById", query = "SELECT p FROM Developer p WHERE p.id = :id"),
        @NamedQuery(name = "developer.deleteAll", query = "DELETE FROM Developer"),
        @NamedQuery(name = "developer.deleteById", query = "DELETE FROM Developer WHERE id = :id")
})
public class Developer {

    private long id;
    private String name;
    private String founder;

    Developer(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

}
