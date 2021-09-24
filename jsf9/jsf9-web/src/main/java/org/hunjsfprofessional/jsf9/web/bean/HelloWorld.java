package org.hunjsfprofessional.jsf9.web.bean;

import lombok.Getter;
import org.hunjsfprofessional.jsf9.ejb.domain.dao.WorldDao;
import org.hunjsfprofessional.jsf9.ejb.domain.entities.World;
import org.hunjsfprofessional.jsf9.jbpm.integration.controller.EjbInteg;
import org.hunjsfprofessional.jsf9.jbpm.integration.model.TaskView;
import org.hunjsfprofessional.jsf9.jbpm.integration.view.TaskViewDao;

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
	private TaskViewDao taskViewDao;

	@Inject
	private EjbInteg processManagerBean;

	public HelloWorld() {
		System.out.println("HelloWorld started!");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("HelloWorld Constructed!");
		world = new World();
		final Long pid = processManagerBean.start();
		processManagerBean.leptet(pid);
	}
	
	public void saveWorld() {
		worldDao.save(world);
	}
	
	public List<World> getAllWorlds() {
		return worldDao.findAll();
	}

	public List<TaskView> getAllTasks() {
		return taskViewDao.findAll();
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