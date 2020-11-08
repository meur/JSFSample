package org.hunjfsprofessional.jsf9.ejb.domain.dao;

import com.querydsl.jpa.impl.JPAQuery;
import org.hunjfsprofessional.jsf9.ejb.domain.base.BaseDao;
import org.hunjfsprofessional.jsf9.ejb.domain.entities.World;

import javax.ejb.Stateless;

import static org.hunjfsprofessional.jsf9.ejb.domain.entities.QWorld.world;

@Stateless
public class WorldDao extends BaseDao<World> {

	@Override
	public Class<World> getPersistentClass() {
		return World.class;
	}

	public Long findHelloedCount() {
		return new JPAQuery<World>(em)
				.from(world)
				.where(world.helloed.isTrue())
				.fetchCount();
	}
}
