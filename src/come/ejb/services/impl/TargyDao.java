package come.ejb.services.impl;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.AbstractDao;
import com.jpa.entities.Targy;



@Stateless
public class TargyDao extends AbstractDao<Targy, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public TargyDao(){
		super(Targy.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}
