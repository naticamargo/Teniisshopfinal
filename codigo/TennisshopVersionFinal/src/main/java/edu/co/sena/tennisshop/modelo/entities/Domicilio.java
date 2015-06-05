/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.modelo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aprendiz
 */
@Entity
@Table(name = "domicilio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d"),
    @NamedQuery(name = "Domicilio.findByIdDOMICILIO", query = "SELECT d FROM Domicilio d WHERE d.idDOMICILIO = :idDOMICILIO"),
    @NamedQuery(name = "Domicilio.findByDirrecion", query = "SELECT d FROM Domicilio d WHERE d.dirrecion = :dirrecion"),
    @NamedQuery(name = "Domicilio.findByTelefono", query = "SELECT d FROM Domicilio d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Domicilio.findByLocalidad", query = "SELECT d FROM Domicilio d WHERE d.localidad = :localidad"),
    @NamedQuery(name = "Domicilio.findByBarrio", query = "SELECT d FROM Domicilio d WHERE d.barrio = :barrio")})
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDOMICILIO")
    private Integer idDOMICILIO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DIRRECION")
    private String dirrecion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 45)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Size(max = 45)
    @Column(name = "BARRIO")
    private String barrio;
    @JoinColumn(name = "MUNICIPIO_idMUNICIPIO", referencedColumnName = "idMUNICIPIO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Municipio mUNICIPIOidMUNICIPIO;
    @JoinColumns({
        @JoinColumn(name = "CUENTA_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO"),
        @JoinColumn(name = "CUENTA_NUMERO_DOCUMENTO", referencedColumnName = "NUMERO_DOCUMENTO")})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuenta cuenta;

    public Domicilio() {
    }

    public Domicilio(Integer idDOMICILIO) {
        this.idDOMICILIO = idDOMICILIO;
    }

    public Domicilio(Integer idDOMICILIO, String dirrecion, String telefono) {
        this.idDOMICILIO = idDOMICILIO;
        this.dirrecion = dirrecion;
        this.telefono = telefono;
    }

    public Integer getIdDOMICILIO() {
        return idDOMICILIO;
    }

    public void setIdDOMICILIO(Integer idDOMICILIO) {
        this.idDOMICILIO = idDOMICILIO;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Municipio getMUNICIPIOidMUNICIPIO() {
        return mUNICIPIOidMUNICIPIO;
    }

    public void setMUNICIPIOidMUNICIPIO(Municipio mUNICIPIOidMUNICIPIO) {
        this.mUNICIPIOidMUNICIPIO = mUNICIPIOidMUNICIPIO;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDOMICILIO != null ? idDOMICILIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.idDOMICILIO == null && other.idDOMICILIO != null) || (this.idDOMICILIO != null && !this.idDOMICILIO.equals(other.idDOMICILIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tennisshop.modelo.entities.Domicilio[ idDOMICILIO=" + idDOMICILIO + " ]";
    }
    
}
