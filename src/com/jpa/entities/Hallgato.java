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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hallgato")
public class Hallgato {
	// ~~~ Attributes ~~~
	
		// ID: hallgatoId

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="hallgatoID")
		private int hallgatoID;

		public int getHallgatoID() { return hallgatoID; }

		// nev
		@Column(name="nev")
		private String nev;


		public String getNev() { return nev; }
		public void setNev(String setnev) { nev = setnev; }

		// neptun
		@Column(name="neptun")
		private String neptun;
		
		public String getNeptun() { return neptun; }
		public void setNeptun(String setneptun) { neptun = setneptun; }
		
		// jelszo
		@Column(name ="jelszo")
		private String jelszo;
		
		public String getJelszo() { return jelszo; }
		public void setJelszo(String setjelszo) { jelszo = setjelszo; }
		
		// logged in
		@Column(name = "login")
		private boolean login;
		
		public boolean isLogin() {
			return login;
		}
		public void trueLogin() {
			login = true;
		}
		
		public void falseLogin() {
			login = false;
		}

	// ~~~ Connections ~~~
		
		

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "kepzesId")	
		private Kepzes kepzes;
		
		public Kepzes getKepzes() {return kepzes;}
		public void setKepzes(Kepzes setkepzes) { kepzes = setkepzes; }
				

		@ManyToMany
		private List<Targy> targyak;
		
		public void addTargy(Targy addtargy) { 
			targyak.add(addtargy); 
			addtargy.addHallgato(this);
		}

		public void removeTargy(Targy removetargy) { 
			targyak.remove(removetargy); 
			removetargy.removeHallgato(this);
		}
		
		
		@ManyToMany
		private List<Vizsga> vizsgak;
		
		public void addVizsga(Vizsga addvizsga) { 
			vizsgak.add(addvizsga); 
			addvizsga.addHallgato(this);
		}
		public void removeVizsga(Vizsga removevizsga) { 
			vizsgak.remove(removevizsga); 
			removevizsga.removeHallgato(this);
		}
		
		
		
		
		
}
