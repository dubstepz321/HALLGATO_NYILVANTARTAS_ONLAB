package com.gui.controllers;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


import com.jpa.entities.Hallgato;
import com.jpa.entities.Kepzes;
import com.jpa.entities.Targy;
import com.jpa.entities.Vizsga;

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
		for(Hallgato hallgatotemp : hallgatok) {hallgatotemp.falseLogin(); hallgatoDao.update(hallgatotemp); }
		
		for(Hallgato hallgatotemp : hallgatok)
		{
			if(hallgatotemp.getNeptun().equals(hallgato.getNeptun())  &&  hallgatotemp.getJelszo().equals((String)hallgato.getJelszo()))
				{ 
				hallgatotemp.trueLogin();
				hallgatoDao.update(hallgatotemp);
				init();
				return "loggedin.xhtml?faces-redirect=true"; }
		}
		return "login.xhtml";
	}
	
	public Hallgato loggedAccount()
	{
		for(Hallgato hallgatotemp : hallgatok)
		{
			if(hallgatotemp.isLogin())
				return hallgatotemp;
		}
		return null;
	}
	
	public void addVizsgaToLoggedAccount(Vizsga vizsga)
	{
		Hallgato loggedAccount = loggedAccount();
		
		for(Targy targy : loggedAccount.getTargyak())
		{
			if(vizsga.getTargy().getTargyId() == targy.getTargyId())
			{
				loggedAccount.addVizsga(vizsga);
				hallgatoDao.update(loggedAccount);
				init();
				
				break;
			}
				
		}
		
		
		
		
	}
	
	public void addTargyToLoggedAccount(Targy targy)
	{
		Hallgato loggedAccount = loggedAccount();
		
		
		if(loggedAccount.getKepzes() != null && loggedAccount.getKepzes().getKepzesID() == targy.getKepzes().getKepzesID())
			{	loggedAccount.addTargy(targy);
				hallgatoDao.update(loggedAccount);
				init();
			}
		
	}
	
	public void setKepzesToLoggedAccount(Kepzes kepzes)
	{
		Hallgato loggedAccount = loggedAccount();
		if(loggedAccount.getKepzes() == null)
		{	
			loggedAccount.setKepzes(kepzes);
			hallgatoDao.update(loggedAccount);
		}
		
		init();
	}
	public void removeVizsgaFromLoggedAccount(int id)
	{
		Hallgato loggedAccount = loggedAccount();
		loggedAccount.removeVizsgaById(id);
		hallgatoDao.update(loggedAccount);
		
		init();
	}
	
	public void removeTargyFromLoggedAccount(int id)
	{
		Hallgato loggedAccount = loggedAccount();
		loggedAccount.removeTargyById(id);
		hallgatoDao.update(loggedAccount);
		
		init();
	}
	
	public void removeKepzesFromLoggedAccount()
	{
		Hallgato loggedAccount = loggedAccount();
		loggedAccount.removeKepzes();
		loggedAccount.removeAllTargy();
		loggedAccount.removeAllVizsga();
		hallgatoDao.update(loggedAccount);
		
		init();
	}
	
	
	

	@PostConstruct
	public void init() {
		hallgato = new Hallgato();
		hallgatok = hallgatoDao.findAll();
	}
	
	
	
	/*
	Set<Targy> newlist = null;
	Targy targy;
	public Set<Targy> getTargyByLoggedKepzes() 
	{
		Hallgato loggedAccount = loggedAccount();
		
		
		
		for(Targy targy : loggedAccount.getTargyak())
			if ( targy.getKepzes().getKepzesID() == loggedAccount.getKepzes().getKepzesID() )
			{
				newlist.add(targy);
			}
		
		return newlist;
	}*/
	
	
	
	public Set<Targy> getLoggedTargyak()
	{
		Set<Targy> targyak;
		targyak = loggedAccount().getTargyak();
		
		return targyak;
	}
	
	public Kepzes getLoggedKepzes()
	{
		Kepzes kepzes = loggedAccount().getKepzes();
		
		return kepzes;
	}
	
	public Set<Vizsga> getLoggedVizsgak()
	{
		Set<Vizsga> vizsgak;
		vizsgak = loggedAccount().getVizsgak();
		
		return vizsgak;
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
