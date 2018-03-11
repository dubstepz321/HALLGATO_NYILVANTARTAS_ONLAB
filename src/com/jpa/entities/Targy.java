package com.jpa.entities;

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
@Table(name = "Targy")
public class Targy {
	
	// ~~~ Attributes ~~~
	
		// ID: KEPZES_ID
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="KEPZES_ID")
		private long TARGY_ID;
		
		public long getKepzesID() { return TARGY_ID; }
		
		// Targykod
		@Column(name="Targykod")
		private String Targykod;
		
		private String getTargykod() { return Targykod; }
		private void setTargykod(String settargykod) { Targykod = settargykod; }
		
		// Kredit
		@Column(name="Kredit")
		private String Kredit;
		
		private String getKredit() { return Kredit; }
		private void setKredit(String setkredit) { Kredit = setkredit; }
		
	// ~~~ Connections ~~~
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "KEPZES_ID")	
		private Kepzes kepzes;
		
		public Kepzes getKepzes() {return kepzes;}
		public void setKepzes(Kepzes setkepzes) { kepzes = setkepzes; }
		
		
		@OneToMany(mappedBy = "targy")
		private List<Vizsga> vizsgak;
		
		public void addVizsga(Vizsga addvizsga) { vizsgak.add(addvizsga); }
		public void removeVizsga(Vizsga removevizsga) { vizsgak.remove(removevizsga); }
		
		
		@ManyToMany
		private List<Hallgato> hallgatok;
		
		public void addHallgato(Hallgato addhallgato) { hallgatok.add(addhallgato); }
		public void removeHallgato(Hallgato removehallgato) { hallgatok.remove(removehallgato); }
	
		
}
