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
	
		// ID: kepzesId
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="kepzesId")
		private long kepzesId;
	
		public long getKepzesID() { return kepzesId; }
	
		// nev
		@Column(name="nev")
		private String nev;
	
		public String getNev() { return nev; }
		public void setNev(String setnev) { nev = setnev; }
	
	
	// ~~~ Connections ~~~
	
		@OneToMany(mappedBy = "kepzes")
		private List<Targy> targyak;
		
		public void addTargy(Targy addtargy) { 
			targyak.add(addtargy); 
			addtargy.setKepzes(this); 
		}
		public void removeTargy(Targy removetargy) { 
			targyak.remove(removetargy); 
			removetargy.setKepzes(null);
		}
	
		
		@OneToMany(mappedBy = "kepzes")
		private List<Hallgato> hallgatok;
		
		public void addHallgato(Hallgato addhallgato) { 
			hallgatok.add(addhallgato); 
			addhallgato.setKepzes(this);
		}
		public void removeHallgato(Hallgato removehallgato) { 
			hallgatok.remove(removehallgato); 
			removehallgato.setKepzes(null);
		}
	
	
	
}
