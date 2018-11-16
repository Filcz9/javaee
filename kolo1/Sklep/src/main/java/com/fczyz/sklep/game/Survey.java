package com.fczyz.sklep.game;

import java.util.Date;

public class Survey {

	 Date from;
	 Date to;
	 String freq;

	private long rating;

	public Survey() { super(); }
	//public ComputerGame(String string, Double double1, Date date, Boolean bool)
	//{
	//	super();
	//}
	public Survey(Date from, Date to, String freq) {
		super();
		this.from = from;
		this.to = to;
		this.freq = freq;
		

		//this.rating = rating;
	}
	public Date getFrom()
	{
		return from;
	}
	public void setFrom(Date from)
	{
		this.from = from;
	}
	public Date getTo()
	{
		return to;
	}
	public void setTo(Date to)
	{
		this.to = to;
	}
	public String getFreq()
	{
		return freq;
	}
	public void setFreq(String freq)
	{
		this.freq = freq;
	}
	/*
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
*/
}
