package com.fczyz.sklep.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fczyz.sklep.game.*;

public class GameService {

	public static List<ComputerGame> db = new ArrayList<ComputerGame>();
	

	public void add(ComputerGame ComputerGame){
		ComputerGame newComputerGame = new ComputerGame(ComputerGame.getTitle(), ComputerGame.getPrice(), ComputerGame.getReleaseDate(), ComputerGame.getAvailable());
		db.add(newComputerGame);
	}

	public void delete(String name)
	{
		Iterator<ComputerGame> iterator = db.iterator();
		while(iterator.hasNext())
		{
			ComputerGame game = iterator.next();
			if(game.getTitle().equals(name))
			{
				iterator.remove();
			}
		}

	}
	public ComputerGame findByTitle(String title)
	{
		for(ComputerGame game : db)
		{
			if(game.getTitle()==title)
				return game;
		}
		return null;
	}

	public List<ComputerGame> getAllComputerGames(){
		return db;
	}
}
