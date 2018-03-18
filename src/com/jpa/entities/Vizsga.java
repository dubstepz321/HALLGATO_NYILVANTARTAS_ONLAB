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
	
		// ID: VizsgaId
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="VizsgaId")
		private long VizsgaId;
	
		public long getKepzesID() { return VizsgaId; }
	
		// Nev
		@Column(name="Idopont")
		private Date Idopont;
	
		public Date getIdopont() { return Idopont; }
		public void setIdopont(Date setidopont) { Idopont = setidopont; }
	
	
	// ~~~ Connections ~~~
	
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "TargyId")	
		private Targy targy;
		
		public Targy getTargy() {return targy;}
		public void setTargy(Targy settargy) { targy = settargy; }
				
	
		@ManyToMany(mappedBy="vizsgak")
		private List<Hallgato> hallgatok;
		
		public void addHallgato(Hallgato addhallgato) { 
			hallgatok.add(addhallgato); 
			addhallgato.addVizsga(this);
		}
		public void removeHallgato(Hallgato removehallgato) { hallgatok.remove(removehallgato); }

}
