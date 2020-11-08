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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Audited
@Entity
@Getter
@Setter
@Table(name = "felhasznalo")
public class Felhasznalo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "j_felhasznalo_szerepkor",
            joinColumns = { @JoinColumn(name = "id_felhasznalo") },
            inverseJoinColumns = { @JoinColumn(name = "id_szerepkor") })
    private List<Szerepkor> szerepkorok;

}
