package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


import com.jpa.entities.Vizsga;

import come.ejb.services.impl.TargyDao;
import come.ejb.services.impl.VizsgaDao;



@Named
@RequestScoped
public class VizsgaController {

	
	@EJB
	VizsgaDao vizsgaDao;
	
	private Vizsga vizsga;
	
	private List<Vizsga> vizsgak;

	@PostConstruct
	public void init() {
		vizsga = new Vizsga();
		vizsgak = vizsgaDao.findAll();
	}
	
	public void create() {
		vizsgaDao.create(vizsga);
		init();	
	}
	
	public void delete() {
		vizsgaDao.delete(vizsga);
		init();
	}
	
	public void deleteById(int id) {
		vizsgaDao.deleteById(id);
		init();
	}
	
	
	
	
	////////////////
	@EJB
	TargyDao targyDao;
	
	private int targyID;
	
	public int getTargyID() {
		return targyID;
	}

	public void setTargyID(int targyID) {
		this.targyID = targyID;
	}

	
	public void createAndLink(int targyid)
	{
		vizsga.setTargy(targyDao.findById(targyid));
		
		vizsgaDao.create(vizsga);
		init();
	}
	
	
	
	

	
	
	public Vizsga getVizsga() {
		return vizsga;
	}

	public void setVizsga(Vizsga vizsga) {
		this.vizsga = vizsga;
	}

	public List<Vizsga> getVizsgak() {
		return vizsgak;
	}

	public void setVizsgak(List<Vizsga> vizsgak) {
		this.vizsgak = vizsgak;
	}
	
	
}
