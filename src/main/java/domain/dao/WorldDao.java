package domain.dao;

import javax.ejb.Stateless;

import domain.World;

@Stateless
public class WorldDao extends BaseDao<World> {

	@Override
	public Class<World> getPersistentClass() {
		return World.class;
	}
	
}
