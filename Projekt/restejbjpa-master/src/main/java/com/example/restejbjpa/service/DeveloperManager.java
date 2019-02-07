package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Developer;
import com.example.restejbjpa.domain.ComputerGame;

@Stateless
public class DeveloperManager {

    @PersistenceContext
    EntityManager em;

    public Developer getDeveloper(Long id){
        return (Developer) em.createNamedQuery("developer.getById").setParameter("id", id).getResultList().get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Developer> getAllDevelopers(){
        return em.createNamedQuery("developer.getAll").getResultList();
    }

    public void addDeveloper(Developer developer){
        em.persist(developer);
    }

    public void deleteAll(){
        em.createNamedQuery("developer.deleteAll").executeUpdate();
    }

    public void deleteById(Long id) {
        Developer toDelete = getDeveloper(id);

        em.remove(toDelete);
    }

    public Developer updateDeveloper(Long id, Developer developer) {
        developer.setId(id);
        getDeveloper(id);
        return em.merge(developer);
    }
}

