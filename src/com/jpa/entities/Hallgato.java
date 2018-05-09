package com.jpa.entities;



import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
		
		

		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "kepzesId")
		private Kepzes kepzes;
		
		public Kepzes getKepzes() {return kepzes;}
		public void setKepzes(Kepzes setkepzes) { kepzes = setkepzes; }
		public void removeKepzes() { kepzes = null; }
				

		@ManyToMany(fetch = FetchType.EAGER)
		private Set<Targy> targyak;
		
		public void addTargy(Targy addtargy) { 
			targyak.add(addtargy); 
			addtargy.addHallgato(this);
		}

		public void removeTargy(Targy removetargy) { 
			targyak.remove(removetargy); 
			removetargy.removeHallgato(this);
		}
		
		public void removeTargyById(int id) { 
			Iterator<Targy> iter = targyak.iterator();

			while (iter.hasNext()) {
			    Targy str = iter.next();

			    if (str.getTargyId() == id)
			        iter.remove();
			}
			/*
			for(Targy targy : targyak)
			{
				if(targy.getTargyId()==id)
					targyak.remove(targy);
			}*/
			
			
		}
		
		public void removeAllTargy()
		{
			targyak.clear();
		}
		
		
		public Set<Targy> getTargyak() {
			return targyak;
		}

		@ManyToMany(fetch = FetchType.EAGER)
		private Set<Vizsga> vizsgak;
		
		public void addVizsga(Vizsga addvizsga) { 
			vizsgak.add(addvizsga); 
			addvizsga.addHallgato(this);
		}
		public void removeVizsga(Vizsga removevizsga) { 
			vizsgak.remove(removevizsga); 
			removevizsga.removeHallgato(this);
		}
		
		public void removeVizsgaById(int id) { 
			Iterator<Vizsga> iter = vizsgak.iterator();

			while (iter.hasNext()) {
			    Vizsga str = iter.next();

			    if (str.getVizsgaID() == id)
			        iter.remove();
			}
		}
		
		public void removeAllVizsga()
		{
			vizsgak.clear();
		}
		
		public Set<Vizsga> getVizsgak() {
			return vizsgak;
		}
		
		
		
		
		
}
