package org.hunjsfprofessional.jsf9.jbpm.integration.view;

import org.hunjsfprofessional.jsf9.jbpm.integration.model.TaskView;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class TaskViewDao {

    @Inject
    private EntityManager em;

    public List<TaskView> findAll() {
        return em.createQuery("select t from " + TaskView.class.getSimpleName() + " t").getResultList();
    }
}
