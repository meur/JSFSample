package org.hunjsfprofessional.jsf9.jbpm.integration.model;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "view_task")
public class TaskView {
    @Id
    Long id;
    String status;

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
