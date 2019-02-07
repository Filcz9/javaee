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
        @NamedQuery(name = "description.getAll", query = "SELECT p FROM Description p"),
        @NamedQuery(name = "description.getById", query = "SELECT p FROM Description p WHERE p.id = :id"),
        @NamedQuery(name = "description.deleteAll", query = "DELETE FROM Description"),
        @NamedQuery(name = "description.deleteById", query = "DELETE FROM Description WHERE id = :id")
})
public class Description {

    private long id;
    private String desc;

    Description(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
