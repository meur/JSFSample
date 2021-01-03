package org.hunjsfprofessional.jsf9.ejb.domain.base;

import javax.ejb.Stateless;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless
public class EntityManagerProducer {

	@PersistenceUnit(unitName = "org.jbpm.domain")
	private EntityManagerFactory emf;

	@Produces
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	@Produces
	public EntityManager getEm() {
		return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
		em.close();
	}
}
