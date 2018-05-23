package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ejb.services.impl.KepzesDao;
import com.ejb.services.impl.TargyDao;
import com.jpa.entities.Targy;

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
	
	
	
	///////
	@EJB
	KepzesDao kepzesDao;
	
	private int kepzesID;
	
	public int getKepzesID() {
		return kepzesID;
	}

	public void setKepzesID(int kepzesID) {
		this.kepzesID = kepzesID;
	}

	
	public void createAndLink(int kepzesid)
	{
		targy.setKepzes(kepzesDao.findById(kepzesid));
		
		targyDao.create(targy);
		init();
	}
	
	//////
	
	
	
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
