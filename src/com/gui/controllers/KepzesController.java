package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


import com.jpa.entities.Kepzes;

import come.ejb.services.impl.KepzesDao;

@Named
@RequestScoped
public class KepzesController {

	@EJB
	KepzesDao kepzesDao;
	
	private Kepzes kepzes;
	
	private List<Kepzes> kepzesek;
	
	//getter setter
	public Kepzes getKepzes() {
		return kepzes;
	}

	public void setKepzes(Kepzes kepzes) {
		this.kepzes = kepzes;
	}

	public List<Kepzes> getKepzesek() {
		return kepzesek;
	}

	public void setKepzesek(List<Kepzes> kepzesek) {
		this.kepzesek = kepzesek;
	}
	/////
	
	public void create()
	{
		kepzesDao.create(kepzes);
		init();
	}
	

	public void delete() {
		kepzesDao.delete(kepzes);
		init();
	}
	
	public void deleteById(int id) {
		kepzesDao.deleteById(id);
		init();
	}
	
	@PostConstruct
	public void init() {
		kepzes = new Kepzes();
		kepzesek = kepzesDao.findAll();
	}
	
}
