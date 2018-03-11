package com.jpa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Vizsga")
public class Vizsga {
	
	// ~~~ Attributes ~~~
	
		// ID: VIZSGA_ID
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="VIZSGA_ID")
		private long VIZSGA_ID;
	
		public long getKepzesID() { return VIZSGA_ID; }
	
		// Nev
		@Column(name="Idopont")
		private Date Idopont;
	
		private Date getIdopont() { return Idopont; }
		private void setIdopont(Date setidopont) { Idopont = setidopont; }
	
	
	// ~~~ Connections ~~~
	
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "TARGY_ID")	
		private Targy targy;
		
		public Targy getTargy() {return targy;}
		public void setTargy(Targy settargy) { targy = settargy; }
				
	
		@ManyToMany
		private List<Hallgato> hallgatok;
		
		public void addHallgato(Hallgato addhallgato) { hallgatok.add(addhallgato); }
		public void removeHallgato(Hallgato removehallgato) { hallgatok.remove(removehallgato); }

}
