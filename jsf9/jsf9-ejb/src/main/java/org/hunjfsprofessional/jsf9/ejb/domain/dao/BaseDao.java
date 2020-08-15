package org.hunjfsprofessional.jsf9.ejb.domain.dao;

import org.hunjfsprofessional.jsf9.ejb.domain.entities.BaseEntity;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@TransactionAttribute(TransactionAttributeType.REQUIRED)
public abstract class BaseDao<T extends BaseEntity> implements Serializable {

	private static final long serialVersionUID = 2955845525838069445L;

	public abstract Class<T> getPersistentClass();

	@Inject
	protected EntityManager em;

	public void save(final T entitas) {
		if (entitas.isNew()) {
			em.persist(entitas);
		}
		else {
			em.merge(entitas);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return em.createQuery("Select t from " + getPersistentClass().getSimpleName() + " t").getResultList();
	}

	public T find(final Object id) {
		return em.find(getPersistentClass(), id);
	}

	public void remove(final T entitas) {
		em.remove(entitas);
	}
}
