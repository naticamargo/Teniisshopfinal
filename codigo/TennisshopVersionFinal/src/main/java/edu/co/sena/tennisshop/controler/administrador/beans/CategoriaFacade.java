/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.controler.administrador.beans;

import edu.co.sena.tennisshop.modelo.entities.Categoria;
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
public class CategoriaFacade extends AbstractFacade<Categoria> {
    @PersistenceContext(unitName = "com.mycompany_TennisshopVersionFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
       public List<Categoria> findById(Object id) {
        Query queryJPQL =getEntityManager().createNamedQuery("Categoria.findByIdCategoria");
        queryJPQL.setParameter("idCategoria",id);
        return queryJPQL.getResultList();
    }
    
    public List<Categoria> findByParteNombre(String nombrecatBuscar) {
        String sqlQuery = "SELECT * FROM Categoria ca where cat.NOMBRE like '%"+nombrecatBuscar+"%';";
        Query query2 = getEntityManager().createNativeQuery(sqlQuery, Categoria.class);
        return query2.getResultList();
    }
    
}
