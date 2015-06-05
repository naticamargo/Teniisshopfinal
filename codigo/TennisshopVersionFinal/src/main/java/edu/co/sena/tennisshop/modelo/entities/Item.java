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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByCantidad", query = "SELECT i FROM Item i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Item.findByValorUnitario", query = "SELECT i FROM Item i WHERE i.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Item.findByValorTotal", query = "SELECT i FROM Item i WHERE i.valorTotal = :valorTotal"),
    @NamedQuery(name = "Item.findByProductoIdProducto", query = "SELECT i FROM Item i WHERE i.itemPK.productoIdProducto = :productoIdProducto"),
    @NamedQuery(name = "Item.findByPedidoFacturaIdFactura", query = "SELECT i FROM Item i WHERE i.itemPK.pedidoFacturaIdFactura = :pedidoFacturaIdFactura")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemPK itemPK;
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
    @JoinColumn(name = "PRODUCTO_ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "PEDIDO_FACTURA_ID_FACTURA", referencedColumnName = "FACTURA_ID_FACTURA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pedido pedido;

    public Item() {
    }

    public Item(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public Item(ItemPK itemPK, int cantidad, float valorUnitario, float valorTotal) {
        this.itemPK = itemPK;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public Item(String productoIdProducto, int pedidoFacturaIdFactura) {
        this.itemPK = new ItemPK(productoIdProducto, pedidoFacturaIdFactura);
    }

    public ItemPK getItemPK() {
        return itemPK;
    }

    public void setItemPK(ItemPK itemPK) {
        this.itemPK = itemPK;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemPK != null ? itemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemPK == null && other.itemPK != null) || (this.itemPK != null && !this.itemPK.equals(other.itemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tennisshop.modelo.entities.Item[ itemPK=" + itemPK + " ]";
    }
    
}
