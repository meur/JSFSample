package org.hunjsfprofessional.jsf9.jbpm.integration;

import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.services.api.model.DeploymentUnit;
import org.jbpm.services.ejb.api.DefinitionServiceEJBLocal;
import org.jbpm.services.ejb.api.DeploymentServiceEJBLocal;
import org.jbpm.services.ejb.api.ProcessServiceEJBLocal;
import org.jbpm.services.ejb.api.RuntimeDataServiceEJBLocal;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class EjbInteg {

    @EJB
    private DefinitionServiceEJBLocal bpmn2Service;

    @EJB
    private DeploymentServiceEJBLocal deploymentService;

    @EJB
    private ProcessServiceEJBLocal processService;

    @EJB
    private RuntimeDataServiceEJBLocal runtimeDataService;

    public void start() {
        DeploymentUnit deploymentUnit = new KModuleDeploymentUnit("org.hunjsfprofessional", "jsf9-jbpm", "0.0.1-SNAPSHOT");
        if (!deploymentService.isDeployed(deploymentUnit.getIdentifier())) {
            deploymentService.deploy(deploymentUnit);
        }

        long processInstanceId = -1;
        Map<String, Object> params = new HashMap<String, Object>();
        processInstanceId = processService.startProcess("org.hunjsfprofessional:jsf9-jbpm:0.0.1-SNAPSHOT", "Process_1", params);
        System.out.println("Process instance " + processInstanceId + " has been successfully started.");
    }

}
