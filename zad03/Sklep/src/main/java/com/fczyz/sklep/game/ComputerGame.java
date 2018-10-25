package com.fczyz.sklep.game;

import java.util.Date;

public class ComputerGame {

	public Date release_date;
	public Double price;
	public Boolean available;
	public String title;
	private long rating;

	public ComputerGame() { super(); }
	//public ComputerGame(String string, Double double1, Date date, Boolean bool)
	//{
	//	super();
	//}
	public ComputerGame(String title, Double price, Date release_date, Boolean available ) {
		super();
		this.title = title;
		this.price = price;
		this.release_date = release_date;
		this.available = available;

		//this.rating = rating;
	}
	public Date getReleaseDate()
	{
		return release_date;
	}
	public void setReleaseDate(Date release_date)
	{
		this.release_date = release_date;
	}
	public Boolean getAvailable()
	{
		return available;
	}
	public void setAvailable(Boolean available)
	{
		this.available = available;
	}
	public Double getPrice()
	{
		return price;
	}
	public void setPrice(Double price)
	{
		this.price = price;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public long getRating()
	{
		return rating;
	}
	public void setRating(long rating)
	{
		this.rating = rating;
	}

}
