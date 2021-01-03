package org.hunjsfprofessional.jsf9.web.bean;

import org.hunjsfprofessional.jsf9.ejb.domain.dao.FelhasznaloDao;
import org.hunjsfprofessional.jsf9.ejb.domain.entities.Felhasznalo;

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

    //todo https://access.redhat.com/documentation/en-us/jboss_enterprise_application_platform/6/html/administration_and_configuration_guide/use_a_security_domain_in_your_application

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
