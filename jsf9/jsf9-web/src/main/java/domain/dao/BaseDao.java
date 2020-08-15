package domain.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@TransactionAttribute(TransactionAttributeType.REQUIRED)
public abstract class BaseDao<T> implements Serializable {

	private static final long serialVersionUID = 2955845525838069445L;

	public abstract Class<T> getPersistentClass();

	@Inject
	private EntityManager em;

	public void save(final T entitas) {
		em.persist(entitas);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return em.createQuery("Select t from " + getPersistentClass().getSimpleName() + " t").getResultList();
	}

}
