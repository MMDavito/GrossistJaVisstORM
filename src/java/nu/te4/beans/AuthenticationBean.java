/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.beans;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 *
 * @author daca97002
 */
@Named
@SessionScoped
public class AuthenticationBean implements Serializable{
    public void goToLogin(){
    }
}
