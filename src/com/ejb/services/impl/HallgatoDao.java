package com.ejb.services.impl;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.AbstractDao;
import com.jpa.entities.Hallgato;



@Stateless
public class HallgatoDao extends AbstractDao<Hallgato, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public HallgatoDao(){
		super(Hallgato.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}
