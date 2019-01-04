package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Car;
import com.example.restejbjpa.domain.ComputerGame;

@Stateless
public class ComputerGameManager {	
	
	@PersistenceContext
	EntityManager em;
	
	public ComputerGame getComputerGame(Long id){
		return em.find(ComputerGame.class, id);
	}
	
	public Car getCar(Long id){
		return em.find(Car.class, id);
	}
	
	public Car updateCar(Car car){
		return em.merge(car);
	}

	
	@SuppressWarnings("unchecked")
	public List<ComputerGame> getAllComputerGames(){
		return em.createNamedQuery("computergame.getAll").getResultList();
	}
	
	public void addComputerGame(ComputerGame computergame){
		em.persist(computergame);		
	}
	
	public void clearComputerGames(){
		em.createNamedQuery("computergame.deleteAll").executeUpdate();
	}

}
