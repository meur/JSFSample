package org.hunjfsprofessional.jsf9.ejb.domain.base;

import javax.persistence.Access;
import javax.persistence.AccessType;

@Access(AccessType.FIELD)
public abstract class BaseEntity {

    abstract public Object getId();

    public boolean isNew() {
        return getId() == null;
    }
}
