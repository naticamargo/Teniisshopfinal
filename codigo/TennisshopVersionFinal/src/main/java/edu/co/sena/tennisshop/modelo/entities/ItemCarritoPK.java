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
public class ItemCarritoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PRODUCTO_ID_PRODUCTO")
    private String productoIdProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CARRITO_COMPRAS_idCARRITO")
    private String cARRITOCOMPRASidCARRITO;

    public ItemCarritoPK() {
    }

    public ItemCarritoPK(String productoIdProducto, String cARRITOCOMPRASidCARRITO) {
        this.productoIdProducto = productoIdProducto;
        this.cARRITOCOMPRASidCARRITO = cARRITOCOMPRASidCARRITO;
    }

    public String getProductoIdProducto() {
        return productoIdProducto;
    }

    public void setProductoIdProducto(String productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
    }

    public String getCARRITOCOMPRASidCARRITO() {
        return cARRITOCOMPRASidCARRITO;
    }

    public void setCARRITOCOMPRASidCARRITO(String cARRITOCOMPRASidCARRITO) {
        this.cARRITOCOMPRASidCARRITO = cARRITOCOMPRASidCARRITO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoIdProducto != null ? productoIdProducto.hashCode() : 0);
        hash += (cARRITOCOMPRASidCARRITO != null ? cARRITOCOMPRASidCARRITO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCarritoPK)) {
            return false;
        }
        ItemCarritoPK other = (ItemCarritoPK) object;
        if ((this.productoIdProducto == null && other.productoIdProducto != null) || (this.productoIdProducto != null && !this.productoIdProducto.equals(other.productoIdProducto))) {
            return false;
        }
        if ((this.cARRITOCOMPRASidCARRITO == null && other.cARRITOCOMPRASidCARRITO != null) || (this.cARRITOCOMPRASidCARRITO != null && !this.cARRITOCOMPRASidCARRITO.equals(other.cARRITOCOMPRASidCARRITO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tennisshop.modelo.entities.ItemCarritoPK[ productoIdProducto=" + productoIdProducto + ", cARRITOCOMPRASidCARRITO=" + cARRITOCOMPRASidCARRITO + " ]";
    }
    
}
