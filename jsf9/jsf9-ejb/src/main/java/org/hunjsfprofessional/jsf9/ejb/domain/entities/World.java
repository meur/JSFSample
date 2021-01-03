package org.hunjsfprofessional.jsf9.ejb.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hunjsfprofessional.jsf9.ejb.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Audited
@Entity
@Table(name = "world")
public class World extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 4931841736107790659L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "universe")
	private String universe;
	
	@Column(name = "helloed")
	private boolean helloed;
	
}
