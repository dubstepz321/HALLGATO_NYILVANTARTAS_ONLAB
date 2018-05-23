package com.ejb.services.impl;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.AbstractDao;
import com.jpa.entities.Kepzes;



@Stateless
public class KepzesDao extends AbstractDao<Kepzes, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public KepzesDao(){
		super(Kepzes.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}
