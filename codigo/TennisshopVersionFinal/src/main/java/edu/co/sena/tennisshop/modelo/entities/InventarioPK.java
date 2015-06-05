/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.modelo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aprendiz
 */
@Embeddable
public class InventarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INVENTARIO")
    private int idInventario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PROVEEDOR_TIPO_DOCUMENTO")
    private String proveedorTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PROVEEDOR_NUMERO_DOCUMENTO")
    private String proveedorNumeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PRODUCTO_ID_PRODUCTO")
    private String productoIdProducto;

    public InventarioPK() {
    }

    public InventarioPK(int idInventario, String proveedorTipoDocumento, String proveedorNumeroDocumento, String productoIdProducto) {
        this.idInventario = idInventario;
        this.proveedorTipoDocumento = proveedorTipoDocumento;
        this.proveedorNumeroDocumento = proveedorNumeroDocumento;
        this.productoIdProducto = productoIdProducto;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getProveedorTipoDocumento() {
        return proveedorTipoDocumento;
    }

    public void setProveedorTipoDocumento(String proveedorTipoDocumento) {
        this.proveedorTipoDocumento = proveedorTipoDocumento;
    }

    public String getProveedorNumeroDocumento() {
        return proveedorNumeroDocumento;
    }

    public void setProveedorNumeroDocumento(String proveedorNumeroDocumento) {
        this.proveedorNumeroDocumento = proveedorNumeroDocumento;
    }

    public String getProductoIdProducto() {
        return productoIdProducto;
    }

    public void setProductoIdProducto(String productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idInventario;
        hash += (proveedorTipoDocumento != null ? proveedorTipoDocumento.hashCode() : 0);
        hash += (proveedorNumeroDocumento != null ? proveedorNumeroDocumento.hashCode() : 0);
        hash += (productoIdProducto != null ? productoIdProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioPK)) {
            return false;
        }
        InventarioPK other = (InventarioPK) object;
        if (this.idInventario != other.idInventario) {
            return false;
        }
        if ((this.proveedorTipoDocumento == null && other.proveedorTipoDocumento != null) || (this.proveedorTipoDocumento != null && !this.proveedorTipoDocumento.equals(other.proveedorTipoDocumento))) {
            return false;
        }
        if ((this.proveedorNumeroDocumento == null && other.proveedorNumeroDocumento != null) || (this.proveedorNumeroDocumento != null && !this.proveedorNumeroDocumento.equals(other.proveedorNumeroDocumento))) {
            return false;
        }
        if ((this.productoIdProducto == null && other.productoIdProducto != null) || (this.productoIdProducto != null && !this.productoIdProducto.equals(other.productoIdProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tennisshop.modelo.entities.InventarioPK[ idInventario=" + idInventario + ", proveedorTipoDocumento=" + proveedorTipoDocumento + ", proveedorNumeroDocumento=" + proveedorNumeroDocumento + ", productoIdProducto=" + productoIdProducto + " ]";
    }
    
}
