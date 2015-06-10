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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByPrimerNombre", query = "SELECT c FROM Cuenta c WHERE c.primerNombre = :primerNombre"),
    @NamedQuery(name = "Cuenta.findBySegundoNombre", query = "SELECT c FROM Cuenta c WHERE c.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Cuenta.findByPrimerApellido", query = "SELECT c FROM Cuenta c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "Cuenta.findBySegundoApellido", query = "SELECT c FROM Cuenta c WHERE c.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Cuenta.findByTipoDocumento", query = "SELECT c FROM Cuenta c WHERE c.cuentaPK.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Cuenta.findByNumeroDocumento", query = "SELECT c FROM Cuenta c WHERE c.cuentaPK.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Cuenta.findByUsuario", query = "SELECT c FROM Cuenta c WHERE c.usuario = :usuario")})
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuentaPK cuentaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 45)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 45)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USUARIO")
    private String usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta", fetch = FetchType.EAGER)
    private List<Factura> facturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta", fetch = FetchType.LAZY)
    private List<Domicilio> domicilioList;
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdUsuario;

    public Cuenta() {
    }

    public Cuenta(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }

    public Cuenta(CuentaPK cuentaPK, String primerNombre, String primerApellido, String usuario) {
        this.cuentaPK = cuentaPK;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.usuario = usuario;
    }

    public Cuenta(String tipoDocumento, String numeroDocumento) {
        this.cuentaPK = new CuentaPK(tipoDocumento, numeroDocumento);
    }

    public CuentaPK getCuentaPK() {
        return cuentaPK;
    }

    public void setCuentaPK(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<Domicilio> getDomicilioList() {
        return domicilioList;
    }

    public void setDomicilioList(List<Domicilio> domicilioList) {
        this.domicilioList = domicilioList;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaPK != null ? cuentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.cuentaPK == null && other.cuentaPK != null) || (this.cuentaPK != null && !this.cuentaPK.equals(other.cuentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tennisshop.modelo.entities.Cuenta[ cuentaPK=" + cuentaPK + " ]";
    }
    
}
