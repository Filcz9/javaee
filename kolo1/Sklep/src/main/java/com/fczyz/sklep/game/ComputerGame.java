package com.fczyz.sklep.game;

import java.util.Date;

public class ComputerGame {

	Date releaseDate;
	 Double price;
	 Boolean available;
	 String title;
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
		this.releaseDate = release_date;
		this.available = available;

		//this.rating = rating;
	}
	public Date getReleaseDate()
	{
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
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
	public String showAll() {
		String state;
		if(this.available)
			state="dostepny";
			else state="niedostepny";
		return "</br>"+"Title: " + this.title + "</br>"+
				"Price: " + this.price + "</br>"+
				
				"Status: " + state + "</br>"+
				"Data wydania: " + this.releaseDate.getDate()+"."+ this.releaseDate.getMonth()+"."+ (this.releaseDate.getYear()+1900)+"</br>";
		
		
}
}
