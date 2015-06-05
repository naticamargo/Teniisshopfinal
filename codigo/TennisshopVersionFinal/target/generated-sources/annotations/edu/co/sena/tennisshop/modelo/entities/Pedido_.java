package edu.co.sena.tennisshop.modelo.entities;

import edu.co.sena.tennisshop.modelo.entities.Factura;
import edu.co.sena.tennisshop.modelo.entities.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-04T14:48:50")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Double> total;
    public static volatile SingularAttribute<Pedido, Factura> factura;
    public static volatile SingularAttribute<Pedido, Double> impuestos;
    public static volatile ListAttribute<Pedido, Item> itemList;
    public static volatile SingularAttribute<Pedido, Integer> facturaIdFactura;
    public static volatile SingularAttribute<Pedido, Double> subtotal;

}