package org.hunjsfprofessional.jsf9.jbpm.integration.controller;

import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.services.api.model.DeploymentUnit;
import org.jbpm.services.ejb.TaskServiceEJBLocal;
import org.jbpm.services.ejb.api.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class EjbInteg {

    @EJB
    private DefinitionServiceEJBLocal bpmn2Service;

    @EJB
    private DeploymentServiceEJBLocal deploymentService;

    @EJB
    private ProcessServiceEJBLocal processService;

    @EJB
    private RuntimeDataServiceEJBLocal runtimeDataService;

    @EJB
    private UserTaskServiceEJBLocal userTaskService;

    @EJB
    private TaskServiceEJBLocal taskService;

    public Long start() {
        DeploymentUnit deploymentUnit = new KModuleDeploymentUnit("org.hunjsfprofessional", "jsf9-jbpm", "0.0.1-SNAPSHOT");
        if (!deploymentService.isDeployed(deploymentUnit.getIdentifier())) {
            deploymentService.deploy(deploymentUnit);
        }

        long processInstanceId = -1;
        Map<String, Object> params = new HashMap<String, Object>();
//        processInstanceId = processService.startProcess("org.hunjsfprofessional:jsf9-jbpm:0.0.1-SNAPSHOT", "Process_1", params);
//        System.out.println("Process instance " + processInstanceId + " has been successfully started.");
        processInstanceId = processService.startProcess("org.hunjsfprofessional:jsf9-jbpm:0.0.1-SNAPSHOT", "Process_2_id", params);
        System.out.println("Process instance " + processInstanceId + " has been successfully started.");

        return processInstanceId;
    }

    public void leptet(final Long processInstanceId) {
        List<Long> taskIds = runtimeDataService.getTasksByProcessInstanceId(processInstanceId);
        //final Task task = userTaskService.getTask(taskIds.get(0));
        if (!taskIds.isEmpty()) {
            userTaskService.claim(taskIds.get(0), "user");
            userTaskService.start(taskIds.get(0), "user");
            userTaskService.complete(taskIds.get(0), "user", null);
//            taskService.complete(taskIds.get(0), "user", null);
        }
    }

}
