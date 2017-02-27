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
import nu.te4.entities.Category;
import nu.te4.sessionbeans.CategoryFacade;

@Named
@SessionScoped
public class CategoryBean implements Serializable{
    @EJB
    CategoryFacade catFacade;
    public List<Category> getCategories(){
        System.out.println("Gets to Categories");
        List<Category> cats = catFacade.findAll();
        for(Category cat: cats){
            System.out.println("categöri " + cat.getName());}
        return catFacade.findAll();
        
    }
    
}
