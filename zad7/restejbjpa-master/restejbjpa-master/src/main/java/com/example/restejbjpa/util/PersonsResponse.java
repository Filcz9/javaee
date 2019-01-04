package com.example.restejbjpa.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.restejbjpa.domain.ComputerGame;

@XmlRootElement
public class ComputerGamesResponse {
	
	private List<ComputerGame> computergame;

	public List<ComputerGame> getComputerGame() {
		return computergame;
	}

	public void setPerson(List<ComputerGame> computergame) {
		this.computergame = computergame;
	}

}
