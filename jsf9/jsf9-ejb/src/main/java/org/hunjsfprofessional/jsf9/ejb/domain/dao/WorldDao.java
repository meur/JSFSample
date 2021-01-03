package org.hunjsfprofessional.jsf9.ejb.domain.dao;

import com.querydsl.jpa.impl.JPAQuery;
import org.hunjsfprofessional.jsf9.ejb.domain.base.BaseDao;
import org.hunjsfprofessional.jsf9.ejb.domain.entities.World;

import javax.ejb.Stateless;

import static org.hunjsfprofessional.jsf9.ejb.domain.entities.QWorld.world;

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
