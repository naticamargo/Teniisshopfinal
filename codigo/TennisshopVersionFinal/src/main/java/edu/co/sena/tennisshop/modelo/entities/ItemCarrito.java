/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.modelo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aprendiz
 */
@Entity
@Table(name = "item_carrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemCarrito.findAll", query = "SELECT i FROM ItemCarrito i"),
    @NamedQuery(name = "ItemCarrito.findByCantidad", query = "SELECT i FROM ItemCarrito i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "ItemCarrito.findByValorUnitario", query = "SELECT i FROM ItemCarrito i WHERE i.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "ItemCarrito.findByValorTotal", query = "SELECT i FROM ItemCarrito i WHERE i.valorTotal = :valorTotal"),
    @NamedQuery(name = "ItemCarrito.findByProductoIdProducto", query = "SELECT i FROM ItemCarrito i WHERE i.itemCarritoPK.productoIdProducto = :productoIdProducto"),
    @NamedQuery(name = "ItemCarrito.findByCARRITOCOMPRASidCARRITO", query = "SELECT i FROM ItemCarrito i WHERE i.itemCarritoPK.cARRITOCOMPRASidCARRITO = :cARRITOCOMPRASidCARRITO")})
public class ItemCarrito implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemCarritoPK itemCarritoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_UNITARIO")
    private float valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_TOTAL")
    private float valorTotal;
    @JoinColumn(name = "CARRITO_COMPRAS_idCARRITO", referencedColumnName = "idCARRITO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CarritoCompras carritoCompras;
    @JoinColumn(name = "PRODUCTO_ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;

    public ItemCarrito() {
    }

    public ItemCarrito(ItemCarritoPK itemCarritoPK) {
        this.itemCarritoPK = itemCarritoPK;
    }

    public ItemCarrito(ItemCarritoPK itemCarritoPK, int cantidad, float valorUnitario, float valorTotal) {
        this.itemCarritoPK = itemCarritoPK;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public ItemCarrito(String productoIdProducto, String cARRITOCOMPRASidCARRITO) {
        this.itemCarritoPK = new ItemCarritoPK(productoIdProducto, cARRITOCOMPRASidCARRITO);
    }

    public ItemCarritoPK getItemCarritoPK() {
        return itemCarritoPK;
    }

    public void setItemCarritoPK(ItemCarritoPK itemCarritoPK) {
        this.itemCarritoPK = itemCarritoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCarritoPK != null ? itemCarritoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCarrito)) {
            return false;
        }
        ItemCarrito other = (ItemCarrito) object;
        if ((this.itemCarritoPK == null && other.itemCarritoPK != null) || (this.itemCarritoPK != null && !this.itemCarritoPK.equals(other.itemCarritoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tennisshop.modelo.entities.ItemCarrito[ itemCarritoPK=" + itemCarritoPK + " ]";
    }
    
}
