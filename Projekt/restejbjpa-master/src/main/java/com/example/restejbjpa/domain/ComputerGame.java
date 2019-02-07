package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name="computergame.getAll", query = "SELECT DISTINCT p from ComputerGame p LEFT JOIN FETCH p.developer pr LEFT JOIN FETCH  p.genres sr LEFT JOIN FETCH  p.description d"),
        @NamedQuery(name="computergame.getByDeveloper", query="SELECT DISTINCT p FROM ComputerGame p LEFT JOIN FETCH p.developer pr LEFT JOIN FETCH  p.genres sr LEFT JOIN FETCH  p.description d WHERE pr.name = :prName"),
        @NamedQuery(name="computergame.getByGenre", query="SELECT DISTINCT p FROM ComputerGame p LEFT JOIN FETCH p.developer pr LEFT JOIN FETCH  p.genres sr LEFT JOIN FETCH  p.description d WHERE sr.name = :srName"),
        @NamedQuery(name="computergame.getByMultiplayer", query="SELECT DISTINCT p FROM ComputerGame p LEFT JOIN FETCH p.developer pr LEFT JOIN FETCH  p.genres sr LEFT JOIN FETCH  p.description d WHERE p.multiplayer = :pMultiplayer"),
        @NamedQuery(name="computergame.getNewerThan", query="SELECT DISTINCT p FROM ComputerGame p LEFT JOIN FETCH p.developer pr LEFT JOIN FETCH  p.genres sr LEFT JOIN FETCH  p.description d WHERE p.yor > :pYor"),
        @NamedQuery(name="computergame.deleteAll", query="Delete from ComputerGame"),
        @NamedQuery(name="computergame.deleteById", query = "DELETE FROM ComputerGame WHERE id = :id")
})
public class ComputerGame {

    private Long id;

    private String title;

    private double price;
    private boolean multiplayer;

    private Date yor;
    private Developer developer;
    private Description description;
    @JsonIgnoreProperties("computerGames")
    private List<Genre> genres = new ArrayList<>();

    public ComputerGame() {
    }

    public ComputerGame(String title, double price, boolean multiplayer, Date yor) {
        this.title = title;
        this.price = price;
        this.multiplayer = multiplayer;
        this.yor = yor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getYor() {
        return yor;
    }
    public void setYor(Date yor) {
        this.yor = yor;
    }


    public double getPrice() { return price; }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean getMultiplayer() { return multiplayer; }
    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Description getDescription() {
        return description;
    }
    public void setDescription(Description description) {
        this.description = description;
    }


    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToMany(fetch = FetchType.LAZY)
    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genres) {
        getGenres().add(genres);
        genres.getComputerGames().add(this);
    }

    public void removeGenre(Genre supportedResolution) {
        getGenres().remove(supportedResolution);
        supportedResolution.getComputerGames().remove(this);
    }
}
