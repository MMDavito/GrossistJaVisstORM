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
import nu.te4.entities.Product;
import nu.te4.sessionbeans.ProductFacade;

/**
 *
 * @author daca97002
 */
@Named
@SessionScoped
public class ProductBean implements Serializable {

    int id, category, price;
    String name, description;

    private String test = "HEJ"; 
    @EJB
    ProductFacade productFacade;

    public List<Product> getProducts() {
        System.out.println("Du kommer till productBean");
        List<Product> prods = productFacade.findAll();
        for (Product tempProd : prods) {
            System.out.println("Temp namn " + tempProd.getName());
        }
        return productFacade.findAll();
    }
    
    public String getTest(){
        return test;
    }

}
