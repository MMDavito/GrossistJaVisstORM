/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nu.te4.entities.SupplierProduct;

/**
 *
 * @author daca97002
 */
@Stateless
public class SupplierProductFacade extends AbstractFacade<SupplierProduct> {

    @PersistenceContext(unitName = "GrossistJaVisstORMPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupplierProductFacade() {
        super(SupplierProduct.class);
    }
    
}
