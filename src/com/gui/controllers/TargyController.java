package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jpa.entities.Targy;

import come.ejb.services.impl.TargyDao;

@Named
@RequestScoped
public class TargyController {

	@EJB
	TargyDao targyDao;
	
	private Targy targy;
	
	private List<Targy> targyak;

	@PostConstruct
	public void init() {
		targy = new Targy();
		targyak = targyDao.findAll();
	}
	
	public void create() {
		targyDao.create(targy);
		init();	
	}
	
	public void delete() {
		targyDao.delete(targy);
		init();
	}
	
	public void deleteById(int id) {
		targyDao.deleteById(id);
		init();
	}
	
	
	
	public Targy getTargy() {
		return targy;
	}

	public void setTargy(Targy targy) {
		this.targy = targy;
	}

	public List<Targy> getTargyak() {
		return targyak;
	}

	public void setTargyak(List<Targy> targyak) {
		this.targyak = targyak;
	}
	
	
	
}
