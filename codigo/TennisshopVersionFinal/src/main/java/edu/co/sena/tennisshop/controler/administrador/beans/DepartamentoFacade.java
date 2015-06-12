/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.controler.administrador.beans;

import edu.co.sena.tennisshop.modelo.entities.Departamento;
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
public class DepartamentoFacade extends AbstractFacade<Departamento> {
    @PersistenceContext(unitName = "com.mycompany_TennisshopVersionFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }
    @Override
    public List<Departamento> findAll() {
        Query queryJPQL = getEntityManager().createNamedQuery("Departamento.findAll");
        return queryJPQL.getResultList();
    }
        
     public List<Departamento> finById(Object id){
     Query queryJPOL =getEntityManager().createNamedQuery("Departamento.findByIdDEPARTAMENTO");
     queryJPOL.setParameter("idDEPARTAMENTO", id);
     return queryJPOL.getResultList();
             
     }
     public List<Departamento> findByParteNombre(String nombreDepBuscar) {
        String sqlQuery = "SELECT * FROM departamento dep where dep.NOMBRE_NOMBRE_DEPARAMENTO like '%"+nombreDepBuscar+"%';";
        Query query2 = getEntityManager().createNativeQuery(sqlQuery, Departamento.class);
        return query2.getResultList();
}
     
    public Departamento findByNombre(Object nombre) {
        Query queryJPQL = getEntityManager().createNamedQuery("Departamento.findByNombreDeparamento");
        queryJPQL.setParameter("nombreDeparamento", nombre);
        return (Departamento) queryJPQL.getSingleResult();
    }
}