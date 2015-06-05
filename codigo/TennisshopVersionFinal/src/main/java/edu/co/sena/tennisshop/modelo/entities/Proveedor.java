/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.modelo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aprendiz
 */
@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByTipoDocumento", query = "SELECT p FROM Proveedor p WHERE p.proveedorPK.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Proveedor.findByNumeroDocumento", query = "SELECT p FROM Proveedor p WHERE p.proveedorPK.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Proveedor.findByNombreProvvedor", query = "SELECT p FROM Proveedor p WHERE p.nombreProvvedor = :nombreProvvedor"),
    @NamedQuery(name = "Proveedor.findByTelefono", query = "SELECT p FROM Proveedor p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Proveedor.findByCorreo", query = "SELECT p FROM Proveedor p WHERE p.correo = :correo")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProveedorPK proveedorPK;
    @Size(max = 45)
    @Column(name = "NOMBRE_PROVVEDOR")
    private String nombreProvvedor;
    @Size(max = 45)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 45)
    @Column(name = "CORREO")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor", fetch = FetchType.EAGER)
    private List<Inventario> inventarioList;

    public Proveedor() {
    }

    public Proveedor(ProveedorPK proveedorPK) {
        this.proveedorPK = proveedorPK;
    }

    public Proveedor(String tipoDocumento, String numeroDocumento) {
        this.proveedorPK = new ProveedorPK(tipoDocumento, numeroDocumento);
    }

    public ProveedorPK getProveedorPK() {
        return proveedorPK;
    }

    public void setProveedorPK(ProveedorPK proveedorPK) {
        this.proveedorPK = proveedorPK;
    }

    public String getNombreProvvedor() {
        return nombreProvvedor;
    }

    public void setNombreProvvedor(String nombreProvvedor) {
        this.nombreProvvedor = nombreProvvedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedorPK != null ? proveedorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.proveedorPK == null && other.proveedorPK != null) || (this.proveedorPK != null && !this.proveedorPK.equals(other.proveedorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tennisshop.modelo.entities.Proveedor[ proveedorPK=" + proveedorPK + " ]";
    }
    
}
