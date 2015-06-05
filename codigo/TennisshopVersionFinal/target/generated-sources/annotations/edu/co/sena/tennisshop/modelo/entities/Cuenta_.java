package edu.co.sena.tennisshop.modelo.entities;

import edu.co.sena.tennisshop.modelo.entities.CuentaPK;
import edu.co.sena.tennisshop.modelo.entities.Domicilio;
import edu.co.sena.tennisshop.modelo.entities.Factura;
import edu.co.sena.tennisshop.modelo.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-04T14:48:50")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, Usuario> usuarioIdUsuario;
    public static volatile ListAttribute<Cuenta, Factura> facturaList;
    public static volatile SingularAttribute<Cuenta, String> primerApellido;
    public static volatile SingularAttribute<Cuenta, String> usuario;
    public static volatile SingularAttribute<Cuenta, CuentaPK> cuentaPK;
    public static volatile SingularAttribute<Cuenta, String> segundoNombre;
    public static volatile ListAttribute<Cuenta, Domicilio> domicilioList;
    public static volatile SingularAttribute<Cuenta, String> primerNombre;
    public static volatile SingularAttribute<Cuenta, String> segundoApellido;

}