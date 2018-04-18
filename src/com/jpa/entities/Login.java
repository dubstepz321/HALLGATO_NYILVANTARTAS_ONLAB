package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class Login {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="loginID")
	private int loginID;

	public int getLoginID() { return loginID; }
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hallgatoID")
	private Hallgato hallgato;

	public Hallgato getHallgato() {
		return hallgato;
	}

	public void setHallgato(Hallgato hallgato) {
		this.hallgato = hallgato;
	}
	
	
	

}
