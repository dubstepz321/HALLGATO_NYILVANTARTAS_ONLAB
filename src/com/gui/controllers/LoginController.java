package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jpa.entities.Hallgato;
import com.jpa.entities.Login;


import come.ejb.services.impl.LoginDao;

@Named
@RequestScoped
public class LoginController {
	@EJB
	LoginDao loginDao;
	
	private Login login;
	
	private List<Login> logins;
	
	public void create()
	{
		loginDao.create(login);
		init();
	}
	
	public void delete() {
		loginDao.delete(login);
		init();
	}
	
	public void deleteById(int id) {
		loginDao.deleteById(id);
		init();
	}
	
	
	
	@PostConstruct
	public void init() {
		login = new Login();
		logins = loginDao.findAll();
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}
}
