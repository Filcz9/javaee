package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Description;
import com.example.restejbjpa.domain.ComputerGame;

@Stateless
public class DescriptionManager {

    @PersistenceContext
    EntityManager em;

    public Description getDescription(Long id){
        return (Description) em.createNamedQuery("description.getById").setParameter("id", id).getResultList().get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Description> getAllDescriptions(){
        return em.createNamedQuery("description.getAll").getResultList();
    }

    public void addDescription(Description description){
        em.persist(description);
    }

    public void deleteAll(){
        em.createNamedQuery("description.deleteAll").executeUpdate();
    }

    public void deleteById(Long id) {
        Description toDelete = getDescription(id);

        em.remove(toDelete);
    }

    public Description updateDescription(Long id, Description description) {
        description.setId(id);
        getDescription(id);
        return em.merge(description);
    }
}
