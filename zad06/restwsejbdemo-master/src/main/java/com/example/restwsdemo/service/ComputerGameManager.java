package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import com.example.restwsdemo.domain.ComputerGame;

@Singleton
public class ComputerGameManager {
	
	private List<ComputerGame> db = Collections.synchronizedList(new ArrayList<>());

	public void addComputerGame(ComputerGame computergame) {
		db.add(computergame);
	}

	public void deleteComputerGame(ComputerGame computergame){
		db.remove(computergame);
 	}
	
	public ComputerGame getComputerGame(Integer id) {
		return new ComputerGame("Gta", "1997", 19.99, true );
	}
	
	public List<ComputerGame> getAllComputerGames(){
		return db;
	}
	
	public void deleteAllComputerGames(){
		db.clear();
	}

}
