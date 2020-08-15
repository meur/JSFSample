package org.hunjfsprofessional.jsf9.ejb.domain.dao;

import javax.ejb.Stateless;

import org.hunjfsprofessional.jsf9.ejb.domain.entities.World;

@Stateless
public class WorldDao extends BaseDao<World> {

	@Override
	public Class<World> getPersistentClass() {
		return World.class;
	}
	
}
