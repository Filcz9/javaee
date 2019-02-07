package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.ComputerGame;
import com.example.restejbjpa.domain.Genre;

@Stateless
public class GenreManager {

    @PersistenceContext
    EntityManager em;

    public Genre getGenre(Long id){  //jest
        return (Genre) em.createNamedQuery("genre.getById").setParameter("id", id).getResultList().get(0);
    }


    public Genre updateGenre(Genre genre){
        return em.merge(genre);
    }

    @SuppressWarnings("unchecked")
    public List<Genre> getAllGenres(){
        return em.createNamedQuery("genre.getAll").getResultList();
    }

    public void addGenre(Genre genre){
        em.persist(genre);
    }

    public void deleteAll(){
        em.createNamedQuery("genre.deleteAll").executeUpdate();
    }

    public void deleteById(Long id) {
        Genre toDelete = getGenre(id);

        em.remove(toDelete);
    }

    public Genre updateGenre(Long id, Genre genre) {
        genre.setId(id);
        getGenre(id);
        return em.merge(genre);
    }

    public Genre getByName(String name) {
        return (Genre) em.createNamedQuery("genre.getByName").setParameter("name", name).getResultList().get(0);

    }

}
