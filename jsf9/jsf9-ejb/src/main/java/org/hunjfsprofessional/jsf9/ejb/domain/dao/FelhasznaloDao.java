package org.hunjfsprofessional.jsf9.ejb.domain.dao;

import com.querydsl.jpa.impl.JPAQuery;
import org.hunjfsprofessional.jsf9.ejb.domain.base.BaseDao;
import org.hunjfsprofessional.jsf9.ejb.domain.entities.Felhasznalo;
import org.hunjfsprofessional.jsf9.ejb.domain.entities.QFelhasznalo;

import javax.ejb.Stateless;

@Stateless
public class FelhasznaloDao extends BaseDao<Felhasznalo> {

    public Class<Felhasznalo> getPersistentClass() {
        return Felhasznalo.class;
    }

    public Felhasznalo findByUsername(final String username) {
        final QFelhasznalo felhasznalo = QFelhasznalo.felhasznalo;
        return new JPAQuery<Felhasznalo>(em).from(felhasznalo)
                .where(felhasznalo.username.eq(username))
                .fetchFirst();
    }
}
