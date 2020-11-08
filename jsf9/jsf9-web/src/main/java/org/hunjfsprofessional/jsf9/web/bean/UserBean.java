package org.hunjfsprofessional.jsf9.web.bean;

import org.hunjfsprofessional.jsf9.ejb.domain.dao.FelhasznaloDao;
import org.hunjfsprofessional.jsf9.ejb.domain.entities.Felhasznalo;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Named
@ViewScoped
public class UserBean implements Serializable {

    @Inject
    private FelhasznaloDao felhasznaloDao;

    private Felhasznalo felhasznalo;

    private String username;

    public String getUsername() {
        if (username == null) {
            username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        }
        return username;
    }

    public Felhasznalo getFelhasznalo() {
        if (felhasznalo == null && getUsername() != null) {
            felhasznalo = felhasznaloDao.findByUsername(getUsername());
        }
        return felhasznalo;
    }

    public void logOut() throws ServletException {
        ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).logout();
    }
}
