package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
	@NamedQuery(name = "computergame.getAll", query = "Select g from ComputerGame g"),
	@NamedQuery(name="computergame.deleteAll", query="Delete from ComputerGame")	
})
public class ComputerGame {
	
	private Long id;
	
	private String title;
	
	private String date;
	
	private double price;
	
	private boolean multiplayer;
	
	private List<Car> cars = new ArrayList<>();
	
	public ComputerGame() {
	}

	public ComputerGame(String title, String date, double price, boolean multiplayer) {
		this.title = title;
		this.date = date;
		this.price = price;
		this.multiplayer = multiplayer;
	}	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
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

	/*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public void addCars(List<Car> cars) {
		
		this.setCars(cars);
		
		for (Car car: cars){
			car.getOwners().add(this);
		} 
	}	*/			
}
