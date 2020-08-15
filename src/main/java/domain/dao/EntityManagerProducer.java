package domain.dao;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EntityManagerProducer {

	@PersistenceContext(name = "helloworld-persistence-unit")
	private EntityManager em;

	@Produces
	public EntityManager getEm() {
		return em;
	}
	
}
