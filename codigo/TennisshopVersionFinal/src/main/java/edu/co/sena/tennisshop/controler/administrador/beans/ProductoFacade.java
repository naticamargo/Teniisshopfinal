/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.controler.administrador.beans;

import edu.co.sena.tennisshop.modelo.entities.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author aprendiz
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {
    @PersistenceContext(unitName = "com.mycompany_TennisshopVersionFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    public List<Producto> finById(Object id) {
        Query queryJPQL = getEntityManager().createNamedQuery("Producto.findByIdProducto");
        queryJPQL.setParameter("idProducto", id);
        return queryJPQL.getResultList();
    }

    public List<Producto> findByNombre(String nombreProBuscar) {
        String sqlQuery = "SELECT * FROM producto pro where pro.NOMBRE_PRODCUTO like '%" + nombreProBuscar + "%';";
        Query query2 = getEntityManager().createNativeQuery(sqlQuery, Producto.class);
        return query2.getResultList();
    }

    public List<Producto> findByIdCategoria(int nombreCategoria) {
        String sqlQuery = "SELECT * FROM producto pro where pro.CATEGORIA_ID_CATEGORIA like '%"  + nombreCategoria + "%';";
        Query query3 = getEntityManager().createNativeQuery(sqlQuery, Producto.class);
        return query3.getResultList();
    }
}
