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
	
		// ID: TargyId
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="TargyId")
		private long TargyId;
		
		public long getKepzesID() { return TargyId; }
		
		// Targykod
		@Column(name="Targykod")
		private String Targykod;
		
		public String getTargykod() { return Targykod; }
		public void setTargykod(String settargykod) { Targykod = settargykod; }
		
		// Kredit
		@Column(name="Kredit")
		private String Kredit;
		
		public String getKredit() { return Kredit; }
		public void setKredit(String setkredit) { Kredit = setkredit; }
		
	// ~~~ Connections ~~~
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "KepzesId")	
		private Kepzes kepzes;
		
		public Kepzes getKepzes() {return kepzes;}
		public void setKepzes(Kepzes setkepzes) { kepzes = setkepzes; }
		
		
		@OneToMany(mappedBy = "targy")
		private List<Vizsga> vizsgak;
		
		public void addVizsga(Vizsga addvizsga) { 
			vizsgak.add(addvizsga);
			addvizsga.setTargy(this);
		}
		public void removeVizsga(Vizsga removevizsga) { vizsgak.remove(removevizsga); }
		
		
		@ManyToMany(mappedBy="targyak")
		private List<Hallgato> hallgatok;
		
		public void addHallgato(Hallgato addhallgato) { 
			hallgatok.add(addhallgato); 
			addhallgato.addTargy(this); 
		}
		public void removeHallgato(Hallgato removehallgato) { hallgatok.remove(removehallgato); }
	
		
}
