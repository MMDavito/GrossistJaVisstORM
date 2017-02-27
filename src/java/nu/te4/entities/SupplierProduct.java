/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daca97002
 */
@Entity
@Table(name = "supplier_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierProduct.findAll", query = "SELECT s FROM SupplierProduct s")
    , @NamedQuery(name = "SupplierProduct.findById", query = "SELECT s FROM SupplierProduct s WHERE s.id = :id")})
public class SupplierProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_sup", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier idSup;
    @JoinColumn(name = "id_prod", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product idProd;

    public SupplierProduct() {
    }

    public SupplierProduct(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supplier getIdSup() {
        return idSup;
    }

    public void setIdSup(Supplier idSup) {
        this.idSup = idSup;
    }

    public Product getIdProd() {
        return idProd;
    }

    public void setIdProd(Product idProd) {
        this.idProd = idProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplierProduct)) {
            return false;
        }
        SupplierProduct other = (SupplierProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nu.te4.entities.SupplierProduct[ id=" + id + " ]";
    }
    
}
