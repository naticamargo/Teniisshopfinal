/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.controler.administrador.beans;

import edu.co.sena.tennisshop.modelo.entities.Catalogo;
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
public class CatalogoFacade extends AbstractFacade<Catalogo> {
    @PersistenceContext(unitName = "com.mycompany_TennisshopVersionFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogoFacade() {
        super(Catalogo.class);
    }
    public List<Catalogo> finById(Object id) {
        Query queryJPQL = getEntityManager().createNamedQuery("Catalogo.findByIdCatologo");
        queryJPQL.setParameter("idCatologo", id);
        return queryJPQL.getResultList();
    }

    public List<Catalogo> findByNombre(String nombreProBuscar) {
        String sqlQuery = "SELECT * FROM tennisshop.catalogo pro where pro.NOMBRE like '%" + nombreProBuscar + "%';";
        Query query2 = getEntityManager().createNativeQuery(sqlQuery, Catalogo.class);
        return query2.getResultList();
    }
}
