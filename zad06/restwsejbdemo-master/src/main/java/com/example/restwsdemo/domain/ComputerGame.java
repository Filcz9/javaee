package com.example.restwsdemo.domain;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ComputerGame {
	
	private String title;
	private String yor;
	private double price;
	private boolean multiplayer;
	
	public ComputerGame() {
	}

	public ComputerGame(String title, String yor, double price, boolean multiplayer) {
		this.title = title;
		this.yor = yor;
		this.price = price;
		this.multiplayer = multiplayer;
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYor() {
		return yor;
	}
	public void setYob(String yor) {
		this.yor = yor;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getMultiplayer() {
		return multiplayer;
	}
	public void setMultiplayer(boolean multiplayer) {
		this.multiplayer = multiplayer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComputerGame other = (ComputerGame) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
