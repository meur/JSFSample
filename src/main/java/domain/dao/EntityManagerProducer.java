package domain.dao;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {
	
	@Produces
	@PersistenceContext(name = "helloworld-persistence-unit")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}
	
}
