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

    public String resourceOwner() {
        String url = "182408392968-asbdmdoat3c6gndk8rjo34ku2u67ib6i.apps.googleusercontent.com";
        
        return null;
    }
}
