package edu.co.sena.tennisshop.modelo.entities;

import edu.co.sena.tennisshop.modelo.entities.Cuenta;
import edu.co.sena.tennisshop.modelo.entities.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-04T14:48:50")
@StaticMetamodel(Domicilio.class)
public class Domicilio_ { 

    public static volatile SingularAttribute<Domicilio, String> localidad;
    public static volatile SingularAttribute<Domicilio, Integer> idDOMICILIO;
    public static volatile SingularAttribute<Domicilio, String> dirrecion;
    public static volatile SingularAttribute<Domicilio, String> telefono;
    public static volatile SingularAttribute<Domicilio, String> barrio;
    public static volatile SingularAttribute<Domicilio, Municipio> mUNICIPIOidMUNICIPIO;
    public static volatile SingularAttribute<Domicilio, Cuenta> cuenta;

}