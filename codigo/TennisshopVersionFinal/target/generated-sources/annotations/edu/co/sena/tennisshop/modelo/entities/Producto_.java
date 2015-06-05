package edu.co.sena.tennisshop.modelo.entities;

import edu.co.sena.tennisshop.modelo.entities.Catalogo;
import edu.co.sena.tennisshop.modelo.entities.Categoria;
import edu.co.sena.tennisshop.modelo.entities.Inventario;
import edu.co.sena.tennisshop.modelo.entities.Item;
import edu.co.sena.tennisshop.modelo.entities.ItemCarrito;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-04T14:48:50")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile ListAttribute<Producto, Inventario> inventarioList;
    public static volatile SingularAttribute<Producto, Boolean> descuento;
    public static volatile SingularAttribute<Producto, byte[]> imagen;
    public static volatile SingularAttribute<Producto, Float> precio;
    public static volatile SingularAttribute<Producto, Categoria> categoriaIdCategoria;
    public static volatile ListAttribute<Producto, Item> itemList;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile SingularAttribute<Producto, Catalogo> catalogoIdCatologo;
    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, String> idProducto;
    public static volatile SingularAttribute<Producto, String> nombreProdcuto;
    public static volatile ListAttribute<Producto, ItemCarrito> itemCarritoList;

}