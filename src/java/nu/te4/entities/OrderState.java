/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daca97002
 */
@Entity
@Table(name = "order_state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderState.findAll", query = "SELECT o FROM OrderState o")
    , @NamedQuery(name = "OrderState.findById", query = "SELECT o FROM OrderState o WHERE o.id = :id")
    , @NamedQuery(name = "OrderState.findByName", query = "SELECT o FROM OrderState o WHERE o.name = :name")
    , @NamedQuery(name = "OrderState.findByDescription", query = "SELECT o FROM OrderState o WHERE o.description = :description")})
public class OrderState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private Collection<Ordering> orderingCollection;

    public OrderState() {
    }

    public OrderState(Integer id) {
        this.id = id;
    }

    public OrderState(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Ordering> getOrderingCollection() {
        return orderingCollection;
    }

    public void setOrderingCollection(Collection<Ordering> orderingCollection) {
        this.orderingCollection = orderingCollection;
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
        if (!(object instanceof OrderState)) {
            return false;
        }
        OrderState other = (OrderState) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nu.te4.beans.OrderState[ id=" + id + " ]";
    }
    
}
