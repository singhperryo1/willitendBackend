package com.willitend.backend.willitendBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "stateinfo")
public class Stateinfo {
	
	@Id
	@Column(name = "name", columnDefinition = "CHAR(2)")
	private String name; 
	
	@Column(name = "hDays", columnDefinition ="INTEGER")
	private int hDays; 
	
	@Column(name = "1Shot", columnDefinition ="INTEGER")
	private int firstShot; 
	
	@Column(name = "2Shot", columnDefinition ="INTEGER")
	private int secShot; 
	
	@Column(name = "vacPerDay", columnDefinition ="INTEGER")
	private int vacPerDay; 
	
	@Column(name = "hPop", columnDefinition ="INTEGER")
	private int hPop; 
	
	@Column(name = "pop", columnDefinition ="INTEGER")
	private int pop; 
	
	public Stateinfo() {
		
	}
	
	public Stateinfo(String name, int hDays, int firstShot, int secShot, int vacPerDay, int hPop, int pop) {
		this.name = name; 
		this.hDays = hDays; 
		this.firstShot = firstShot; 
		this.secShot = secShot; 
		this.vacPerDay = vacPerDay; 
		this.hPop = hPop; 
		this.pop = pop; 
	}
	
	public String getName() {
		return name; 
	}
	
	public int getHDays() {
		return hDays; 
	}
	
	public int getFirstShot() {
		return firstShot; 
	}
	
	public int getSecShot() {
		return secShot; 
	}
	
	public int getVacPerDay() {
		return vacPerDay; 
	}
	
	public int getHPop() {
		return hPop; 
	}
	
	public int getPop() {
		return pop; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public void setHDays(int hDays) {
		this.hDays = hDays; 
	}
	
	public void setFirstShot(int firstShot) {
		this.firstShot = firstShot; 
	}
	
	public void setSecShot(int secShot) {
		this.secShot = secShot; 
	}
	
	public void setVacPerday(int vacPerDay) {
		this.vacPerDay = vacPerDay; 
	}
	
	public void setHPop(int hPop) {
		this.hPop = hPop; 
	}
	
	public void setPop(int pop) {
		this.pop = pop; 
	}
	
	@Override
	public String toString() {
		return "State [name=" + name + ", Herd Immunity Days=" + hDays + ", First Shot Population=" + firstShot + ", Second Shot Population" + secShot + ", Vaccination Per day=" + vacPerDay + ", Vaccinated Population=" + hPop + ", Population=" + pop + "]";  
	}
}
