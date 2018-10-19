package com.fczyz.sklep.game;

import java.util.Date;

public class ComputerGame {

	private Date release_date;
	private Double price;
	private Boolean available;
	private String title;
	private long rating;
	
	public ComputerGame(String string, Double double1, Date date, Boolean bool, long l)
	{
		super();
	}
	public ComputerGame(Date release_date, Double price, Boolean available, String title, long rating) {
		super();
		this.release_date = release_date;
		this.price = price;
		this.available = available;
		this.title = title;
		this.rating = rating;
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
