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

@SessionScoped
@Named
public class TestBean implements Serializable {

    private String name;
    private int age;

    @EJB
    ProductFacade productFacade;

    public TestBean() {
        name = "David";
        age = 20;
    }

    public String getName() {
        try {
           List<Product> products = productFacade.findAll();
           return products.get(0).getName();

        } catch (Exception e) {
            return e.getMessage();
        }
       //return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
