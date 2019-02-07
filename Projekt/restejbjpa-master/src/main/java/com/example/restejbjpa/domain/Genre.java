package com.example.restejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
        @NamedQuery(name = "genre.getAll", query = "SELECT DISTINCT r FROM Genre r LEFT JOIN FETCH r.computerGames g LEFT JOIN FETCH g.developer d LEFT JOIN FETCH g.description ds"),
        @NamedQuery(name = "genre.deleteAll", query = "DELETE FROM Genre"),
        @NamedQuery(name = "genre.getById", query = "SELECT DISTINCT r FROM Genre r LEFT JOIN FETCH r.computerGames g LEFT JOIN FETCH g.developer d LEFT JOIN FETCH g.description ds WHERE r.id = :id"),
        @NamedQuery(name = "genre.getByName", query = "SELECT DISTINCT r FROM Genre r LEFT JOIN FETCH r.computerGames g LEFT JOIN FETCH g.developer d LEFT JOIN FETCH g.description ds WHERE r.name = :name"),
        @NamedQuery(name = "genre.deleteById", query = "DELETE FROM Genre WHERE id = :id")
})
@XmlRootElement
public class Genre {

    private Long id;

    private String name;
    @JsonIgnoreProperties("genres")
    private List<ComputerGame> computerGames = new ArrayList<>();

    public Genre() {
    }

    public Genre(String name) {
        super();
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<ComputerGame> getComputerGames() {
        return computerGames;
    }

    public void setComputerGames(List<ComputerGame> computerGames) {
        this.computerGames = computerGames;
    }

}
