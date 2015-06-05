package edu.co.sena.tennisshop.modelo.entities;

import edu.co.sena.tennisshop.modelo.entities.Departamento;
import edu.co.sena.tennisshop.modelo.entities.Domicilio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-04T14:48:50")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile SingularAttribute<Municipio, Departamento> dEPARTAMENTOidDEPARTAMENTO;
    public static volatile SingularAttribute<Municipio, String> nombreMunicipio;
    public static volatile ListAttribute<Municipio, Domicilio> domicilioList;
    public static volatile SingularAttribute<Municipio, Integer> idMUNICIPIO;

}