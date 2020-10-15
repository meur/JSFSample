package org.hunjfsprofessional.jsf9.ejb.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hunjfsprofessional.jsf9.ejb.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Audited
@Entity
@Getter
@Setter
@Table(name = "szerepkor")
public class Szerepkor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "megnevezes")
    private String megnevezes;

}
