package com.fczyz.sklep.game;

import java.util.Date;

public class Survey {

	 Date from;
	 Date to;
	 String freq;
	 boolean notice;

	private long rating;

	public Survey() { super(); }
	//public ComputerGame(String string, Double double1, Date date, Boolean bool)
	//{
	//	super();
	//}
	public Survey(Date from, Date to, String freq, boolean notice) {
		super();
		this.from = from;
		this.to = to;
		this.freq = freq;
		this.notice = notice;
		

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
	public boolean getNotice()
	{
		return notice;
	}
	public void setNotice(boolean notice)
	{
		this.notice = notice;
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
	public String showAll() {
		String uwaga;
		if(this.notice)
			uwaga="Sprzet nie spelnia oczekiwan";
			else uwaga="Sprzet spelnia oczekiwania";
		return "Uzywany od: " + this.from.getDate()+"."+ (this.from.getMonth()+1)+"."+ (this.from.getYear()+1900)+"</br>"+
				"do: " + this.to.getDate()+"."+ (this.to.getMonth()+1)+"."+ (this.to.getYear()+1900)+"</br>"+
				"</br>"+"Czestotliwosc: " + this.freq + "</br>"+
				"</br>"+"Uwagi: " + uwaga + "</br>";

		
		
}

}
