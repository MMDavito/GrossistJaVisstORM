/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import nu.te4.sessionbeans.CustomerFacade;

/**
 *
 * @author daca97002
 */
@Named
@SessionScoped
public class UserBean implements Serializable {

    boolean loggedIn = false;
    @EJB
    CustomerFacade customerFacade;

}
