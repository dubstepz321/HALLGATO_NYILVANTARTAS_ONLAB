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
	
		// ID: targyId
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="targyId")
		private int targyId;
		
		public int getTargyId() { return targyId; }
		
		// targykod
		@Column(name="targykod")
		private String targykod;
		
		public String getTargykod() { return targykod; }
		public void setTargykod(String settargykod) { targykod = settargykod; }
		
		// targynev
		@Column(name="targynev")
		private String targynev;
		
		public String getTargynev() { return targynev; }
		public void setTargynev(String targynev) { this.targynev = targynev; }

		// kredit
		@Column(name="kredit")
		private String kredit;
		
		public String getKredit() { return kredit; }
		public void setKredit(String setkredit) { kredit = setkredit; }
		
	// ~~~ Connections ~~~
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "kepzesId")	
		private Kepzes kepzes;
		
		public Kepzes getKepzes() {return kepzes;}
		public void setKepzes(Kepzes setkepzes) { kepzes = setkepzes; }
		
		
		@OneToMany(mappedBy = "targy")
		private List<Vizsga> vizsgak;
		
		public void addVizsga(Vizsga addvizsga) { 
			vizsgak.add(addvizsga);
			addvizsga.setTargy(this);
		}
		public void removeVizsga(Vizsga removevizsga) { 
			vizsgak.remove(removevizsga); 
			removevizsga.setTargy(null);
		}
		
		
		@ManyToMany(mappedBy="targyak")
		private List<Hallgato> hallgatok;
		
		public void addHallgato(Hallgato addhallgato) { 
			hallgatok.add(addhallgato); 
			addhallgato.addTargy(this); 
		}
		public void removeHallgato(Hallgato removehallgato) { 
			hallgatok.remove(removehallgato); 
			removehallgato.removeTargy(this);
		}
	
		
}
