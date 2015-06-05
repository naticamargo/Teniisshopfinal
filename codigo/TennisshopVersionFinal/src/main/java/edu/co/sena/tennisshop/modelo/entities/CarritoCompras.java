/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.modelo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author aprendiz
 */
@Entity
@Table(name = "carrito_compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarritoCompras.findAll", query = "SELECT c FROM CarritoCompras c"),
    @NamedQuery(name = "CarritoCompras.findByIdCARRITO", query = "SELECT c FROM CarritoCompras c WHERE c.idCARRITO = :idCARRITO"),
    @NamedQuery(name = "CarritoCompras.findByTotal", query = "SELECT c FROM CarritoCompras c WHERE c.total = :total"),
    @NamedQuery(name = "CarritoCompras.findBySubtotal", query = "SELECT c FROM CarritoCompras c WHERE c.subtotal = :subtotal"),
    @NamedQuery(name = "CarritoCompras.findByImpuestos", query = "SELECT c FROM CarritoCompras c WHERE c.impuestos = :impuestos")})
public class CarritoCompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "idCARRITO")
    private String idCARRITO;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBTOTAL")
    private double subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IMPUESTOS")
    private double impuestos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carritoCompras", fetch = FetchType.EAGER)
    private List<ItemCarrito> itemCarritoList;

    public CarritoCompras() {
    }

    public CarritoCompras(String idCARRITO) {
        this.idCARRITO = idCARRITO;
    }

    public CarritoCompras(String idCARRITO, double total, double subtotal, double impuestos) {
        this.idCARRITO = idCARRITO;
        this.total = total;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
    }

    public String getIdCARRITO() {
        return idCARRITO;
    }

    public void setIdCARRITO(String idCARRITO) {
        this.idCARRITO = idCARRITO;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    @XmlTransient
    public List<ItemCarrito> getItemCarritoList() {
        return itemCarritoList;
    }

    public void setItemCarritoList(List<ItemCarrito> itemCarritoList) {
        this.itemCarritoList = itemCarritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCARRITO != null ? idCARRITO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarritoCompras)) {
            return false;
        }
        CarritoCompras other = (CarritoCompras) object;
        if ((this.idCARRITO == null && other.idCARRITO != null) || (this.idCARRITO != null && !this.idCARRITO.equals(other.idCARRITO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tennisshop.modelo.entities.CarritoCompras[ idCARRITO=" + idCARRITO + " ]";
    }
    
}
