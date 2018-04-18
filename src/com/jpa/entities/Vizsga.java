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
import javax.persistence.Table;

@Entity
@Table(name = "Vizsga")
public class Vizsga {
	
	// ~~~ Attributes ~~~
	
		// ID: vizsgaId
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="vizsgaId")
		private int vizsgaId;
	
		public int getKepzesID() { return vizsgaId; }
	
		// idopont
		@Column(name="idopont")
		private Date idopont;
	
		public Date getIdopont() { return idopont; }
		public void setIdopont(Date setidopont) { idopont = setidopont; }
		
		// Targynev
		@Column(name="targynev")
		private String targynev;
		
		public String getTargynev() { return targynev; }
		public void setTargynev(String targynev) { this.targynev = targynev; }
		
	
	
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
		public void removeHallgato(Hallgato removehallgato) { 
			hallgatok.remove(removehallgato); 
			removehallgato.removeVizsga(this);
		}

}
