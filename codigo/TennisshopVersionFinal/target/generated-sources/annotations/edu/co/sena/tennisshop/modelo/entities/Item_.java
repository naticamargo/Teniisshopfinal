package edu.co.sena.tennisshop.modelo.entities;

import edu.co.sena.tennisshop.modelo.entities.ItemPK;
import edu.co.sena.tennisshop.modelo.entities.Pedido;
import edu.co.sena.tennisshop.modelo.entities.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-04T14:48:50")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Float> valorUnitario;
    public static volatile SingularAttribute<Item, Integer> cantidad;
    public static volatile SingularAttribute<Item, Float> valorTotal;
    public static volatile SingularAttribute<Item, Producto> producto;
    public static volatile SingularAttribute<Item, Pedido> pedido;
    public static volatile SingularAttribute<Item, ItemPK> itemPK;

}