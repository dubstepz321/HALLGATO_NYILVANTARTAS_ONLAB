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
@Table(name = "Hallgato")
public class Hallgato {
	// ~~~ Attributes ~~~
	
		//FIXME Minden tagváltozó camelCase legyen, minden entitásban
		// ID: HALLGATO_ID
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="HALLGATO_ID")
		private long HALLGATO_ID;

		public long getHallgatoID() { return HALLGATO_ID; }

		// Nev
		@Column(name="Nev")
		private String Nev;

		//FIXME Miért vannak private getterek/setterek? (Több helyen, más entitásokban is)
		private String getNev() { return Nev; }
		private void setNev(String setnev) { Nev = setnev; }
		
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
		@JoinColumn(name = "KEPZES_ID")	
		private Kepzes kepzes;
		
		public Kepzes getKepzes() {return kepzes;}
		public void setKepzes(Kepzes setkepzes) { kepzes = setkepzes; }
				
		
		//FIXME ManyToMany esetén is ki kell választani egy tulajdonos oldalt, és a másik oldalra odatenni a mappedBy-t, több helyen van ilyen
		//Különben két egyirányú kapcsolatnak tekinti majd a JPA a két oldalt, nem ugyanazon kapcsolat két oldalának.
		@ManyToMany
		private List<Targy> targyak;
		
		//FIXME Az addXXX metódusokat mindenhol úgy érdemes megírni, hogy a kapcsolat másik oldalát is beállítják. 
		public void addTargy(Targy addtargy) { targyak.add(addtargy);}
		public void removeTargy(Targy removetargy) { targyak.remove(removetargy); }
		
		
		@ManyToMany
		private List<Vizsga> vizsgak;
		
		public void addVizsga(Vizsga addvizsga) { vizsgak.add(addvizsga); }
		public void removeVizsga(Vizsga removevizsga) { vizsgak.remove(removevizsga); }
		
	
}
