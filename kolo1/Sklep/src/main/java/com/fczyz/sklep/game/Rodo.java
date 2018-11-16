package com.fczyz.sklep.game;

public class Rodo {
	private boolean rodo=false;
	private boolean license=false;
	private boolean newsletter=false;
	public Rodo() {
		super();
	}
	public Rodo(boolean rodo, boolean license, boolean newsletter) {
		super();
		this.rodo = rodo;
		this.license = license;
		this.newsletter = newsletter;
	}
	public boolean getRodo() {
		return rodo;
	}
	public void setRodo(boolean rodo) {
		this.rodo = rodo;
	}
	public boolean getLicense() {
		return license;
	}
	public void setLicense(boolean license) {
		this.license = license;
	}
	public boolean getNewsletter() {
		return newsletter;
	}
	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
}

