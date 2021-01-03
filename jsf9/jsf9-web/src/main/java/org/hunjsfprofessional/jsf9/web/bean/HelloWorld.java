package org.hunjsfprofessional.jsf9.web.bean;

import lombok.Getter;
import org.hunjsfprofessional.jsf9.ejb.domain.dao.WorldDao;
import org.hunjsfprofessional.jsf9.ejb.domain.entities.World;
import org.hunjsfprofessional.jsf9.jbpm.integration.EjbInteg;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class HelloWorld implements Serializable {

	private static final long serialVersionUID = 3109860261123539564L;

	@Getter
	private World world;
	
	@Inject
	private WorldDao worldDao;

	@Inject
	private EjbInteg processManagerBean;

	public HelloWorld() {
		System.out.println("HelloWorld started!");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("HelloWorld Constructed!");
		world = new World();
		processManagerBean.start();
	}
	
	public void saveWorld() {
		worldDao.save(world);
	}
	
	public List<World> getAllWorlds() {
		return worldDao.findAll();
	}

	public String getMessage() {
		return "Hello World!";
	}

	public World getFirstEntity() {
		return worldDao.find(1L);
	}

	public Long getHelloedCount() {
		return worldDao.findHelloedCount();
	}
}