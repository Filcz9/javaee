package com.fczyz.sklep.service;

import java.util.ArrayList;
import java.util.List;

import com.fczyz.sklep.game.*;;

public class GameService {

	private List<ComputerGame> db = new ArrayList<ComputerGame>();
	
	public void add(ComputerGame ComputerGame){
		ComputerGame newComputerGame = new ComputerGame(ComputerGame.getTitle(), ComputerGame.getPrice(), ComputerGame.getReleaseDate(), ComputerGame.getAvailable(), ComputerGame.getRating());
		db.add(newComputerGame);
	}
	
	public List<ComputerGame> getAllComputerGames(){
		return db;
	}
}
