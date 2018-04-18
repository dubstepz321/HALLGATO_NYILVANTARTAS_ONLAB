package come.ejb.services.impl;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.AbstractDao;
import com.jpa.entities.Login;



@Stateless
public class LoginDao extends AbstractDao<Login, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public LoginDao(){
		super(Login.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}
