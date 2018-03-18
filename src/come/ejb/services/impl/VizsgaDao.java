package come.ejb.services.impl;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.AbstractDao;
import com.jpa.entities.Vizsga;



@Stateless
public class VizsgaDao extends AbstractDao<Vizsga, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public VizsgaDao(){
		super(Vizsga.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}
