package com.fczyz.sklep.service;

import java.util.ArrayList;
import java.util.List;

import com.fczyz.sklep.game.*;

public class SurveyService {

    public static List<ComputerGame> purchase = new ArrayList<ComputerGame>();

    public void add(ComputerGame ComputerGame){
        ComputerGame newComputerGame = new ComputerGame(ComputerGame.getTitle(), ComputerGame.getPrice(), ComputerGame.getReleaseDate(), ComputerGame.getAvailable());
        purchase.add(newComputerGame);
    }

    public List<ComputerGame> getAllComputerGames(){
        return purchase;
    }
}
