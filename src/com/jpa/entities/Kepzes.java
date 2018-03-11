package com.jpa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Kepzes")
public class Kepzes {
	
	// ~~~ Attributes ~~~
	
		// ID: KEPZES_ID
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="KEPZES_ID")
		private long KEPZES_ID;
	
		public long getKepzesID() { return KEPZES_ID; }
	
		// Nev
		@Column(name="Nev")
		private String Nev;
	
		private String getNev() { return Nev; }
		private void setNev(String setnev) { Nev = setnev; }
	
	
	// ~~~ Connections ~~~
	
		@OneToMany(mappedBy = "kepzes")
		private List<Targy> targyak;
		
		public void addTargy(Targy addtargy) { targyak.add(addtargy); }
		public void removeTargy(Targy removetargy) { targyak.remove(removetargy); }
	
		
		@OneToMany(mappedBy = "kepzes")
		private List<Hallgato> hallgatok;
		
		public void addHallgato(Hallgato addhallgato) { hallgatok.add(addhallgato); }
		public void removeHallgato(Hallgato removehallgato) { hallgatok.remove(removehallgato); }
	
	
	
}
