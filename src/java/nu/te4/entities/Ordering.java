/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daca97002
 */
@Entity
@Table(name = "ordering")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordering.findAll", query = "SELECT o FROM Ordering o")
    , @NamedQuery(name = "Ordering.findById", query = "SELECT o FROM Ordering o WHERE o.id = :id")
    , @NamedQuery(name = "Ordering.findByDateChanged", query = "SELECT o FROM Ordering o WHERE o.dateChanged = :dateChanged")
    , @NamedQuery(name = "Ordering.findByDatePosted", query = "SELECT o FROM Ordering o WHERE o.datePosted = :datePosted")})
public class Ordering implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_changed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateChanged;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_posted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePosted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordering")
    private Collection<CustomerOrdering> customerOrderingCollection;
    @JoinColumn(name = "state", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderState state;

    public Ordering() {
    }

    public Ordering(Integer id) {
        this.id = id;
    }

    public Ordering(Integer id, Date dateChanged, Date datePosted) {
        this.id = id;
        this.dateChanged = dateChanged;
        this.datePosted = datePosted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    @XmlTransient
    public Collection<CustomerOrdering> getCustomerOrderingCollection() {
        return customerOrderingCollection;
    }

    public void setCustomerOrderingCollection(Collection<CustomerOrdering> customerOrderingCollection) {
        this.customerOrderingCollection = customerOrderingCollection;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
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
        if (!(object instanceof Ordering)) {
            return false;
        }
        Ordering other = (Ordering) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nu.te4.beans.Ordering[ id=" + id + " ]";
    }
    
}
