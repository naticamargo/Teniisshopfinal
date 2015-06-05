package edu.co.sena.tennisshop.modelo.entities;

import edu.co.sena.tennisshop.modelo.entities.ItemCarrito;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-04T14:48:50")
@StaticMetamodel(CarritoCompras.class)
public class CarritoCompras_ { 

    public static volatile SingularAttribute<CarritoCompras, Double> total;
    public static volatile SingularAttribute<CarritoCompras, Double> impuestos;
    public static volatile SingularAttribute<CarritoCompras, String> idCARRITO;
    public static volatile SingularAttribute<CarritoCompras, Double> subtotal;
    public static volatile ListAttribute<CarritoCompras, ItemCarrito> itemCarritoList;

}