package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


import com.jpa.entities.Hallgato;


import come.ejb.services.impl.HallgatoDao;



@Named
@RequestScoped
public class HallgatoController {
	@EJB
	HallgatoDao hallgatoDao;
	
	private Hallgato hallgato;
	
	private List<Hallgato> hallgatok;
	
	
	public void create()
	{
		hallgatoDao.create(hallgato);
		init();
	}
	
	public void delete() {
		hallgatoDao.delete(hallgato);
		init();
	}
	
	public void deleteById(int id) {
		hallgatoDao.deleteById(id);
		init();
	}
	
	
	
	public String checkAccount()
	{	
			
		for(Hallgato hallgatotemp : hallgatok)
		{
			if(hallgatotemp.getNeptun().equals(hallgato.getNeptun())  &&  hallgatotemp.getJelszo().equals((String)hallgato.getJelszo()))
				{ 
				
				
				return "loggedin.xhtml?faces-redirect=true"; }
		}
		return "login.xhtml";
	}
	
	

	@PostConstruct
	public void init() {
		hallgato = new Hallgato();
		hallgatok = hallgatoDao.findAll();
	}
	
	
	
	public Hallgato getHallgato() {
		return hallgato;
	}

	public void setHallgato(Hallgato hallgato) {
		this.hallgato = hallgato;
	}

	public List<Hallgato> getHallgatok() {
		return hallgatok;
	}

	public void setHallgatok(List<Hallgato> hallgatok) {
		this.hallgatok = hallgatok;
	}
}
