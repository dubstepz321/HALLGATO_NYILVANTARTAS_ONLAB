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
import javax.persistence.Table;

@Entity
@Table(name = "Hallgato")
public class Hallgato {
	// ~~~ Attributes ~~~
	
		// ID: HallgatoId

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="HallgatoId")
		private long HallgatoId;

		public long getHallgatoID() { return HallgatoId; }

		// Nev
		@Column(name="Nev")
		private String Nev;


		public String getNev() { return Nev; }
		public void setNev(String setnev) { Nev = setnev; }

		// Neptun
		@Column(name="Neptun")
		private String Neptun;
		
		public String getNeptun() { return Neptun; }
		public void setNeptun(String setneptun) { Neptun = setneptun; }
		
		// Jelszo
		@Column(name ="Jelszo")
		private String Jelszo;
		
		public String getJelszo() { return Jelszo; }
		public void setJelszo(String setjelszo) { Jelszo = setjelszo; }
		

	// ~~~ Connections ~~~
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "KepzesId")	
		private Kepzes kepzes;
		
		public Kepzes getKepzes() {return kepzes;}
		public void setKepzes(Kepzes setkepzes) { kepzes = setkepzes; }
				

		@ManyToMany
		private List<Targy> targyak;
		
		public void addTargy(Targy addtargy) { 
			targyak.add(addtargy); 
			addtargy.addHallgato(this);
		}

		public void removeTargy(Targy removetargy) { targyak.remove(removetargy); }
		
		
		@ManyToMany
		private List<Vizsga> vizsgak;
		
		public void addVizsga(Vizsga addvizsga) { 
			vizsgak.add(addvizsga); 
			addvizsga.addHallgato(this);
		}
		public void removeVizsga(Vizsga removevizsga) { vizsgak.remove(removevizsga); }
		
	
}
