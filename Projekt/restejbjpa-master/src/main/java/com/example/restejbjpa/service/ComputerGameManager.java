package com.example.restejbjpa.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Description;
import com.example.restejbjpa.domain.Genre;
import com.example.restejbjpa.domain.ComputerGame;

@Stateless
public class ComputerGameManager {

    @PersistenceContext
    EntityManager em;

    public ComputerGame getComputerGame(Long id){
        return em.find(ComputerGame.class, id);
    }

    public Genre getGenre(Long id){
        return em.find(Genre.class, id);
    }

    public Genre updateGenre(Genre genre){
        return em.merge(genre);
    }
    public ComputerGame updateComputerGame(Long id, ComputerGame game) {  //jest
        game.setId(id);
        getComputerGame(id);
        return em.merge(game);
    }

    @SuppressWarnings("unchecked")
    public List<ComputerGame> getAllComputerGames(){
        return em.createNamedQuery("computergame.getAll").getResultList();
    }
    public List<ComputerGame> getComputerGamesByDeveloperName(String name) {  //jest
        return em.createNamedQuery("computergame.getByDeveloper")
                .setParameter("prName", name).getResultList();
    }
    public List<ComputerGame> getComputerGamesWithMultiplayer(boolean name) {  //jest
        return em.createNamedQuery("computergame.getByMultiplayer")
                .setParameter("pMultiplayer", name).getResultList();
    }
    public List<ComputerGame> getNewerThan(Date date){
        return em.createNamedQuery("computergame.getNewerThan").setParameter("pYor", date).getResultList();

    }
    public List<ComputerGame> getComputerGamesByGenreName(String name) {  //jest
        return em.createNamedQuery("computergame.getByGenre")
                .setParameter("srName", name).getResultList();
    }
    public void addComputerGame(ComputerGame computerGame){
        em.persist(computerGame);
    }

    public void deleteById(Long id) {
        ComputerGame toDelete = getComputerGame(id);

        em.remove(toDelete);
    }

    public void clearComputerGames(){
        em.createNamedQuery("computergame.deleteAll").executeUpdate();
    }

}
