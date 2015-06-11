/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.controler.administrador.beans;

import edu.co.sena.tennisshop.modelo.entities.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "com.mycompany_TennisshopVersionFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
     public List<Usuario> finById(Object id) {
        Query queryJPQL = getEntityManager().createNamedQuery("Usuario.findByIdUsuario");
        queryJPQL.setParameter("idUsuario", id);
        return queryJPQL.getResultList();
    }
    
    public List<Usuario> findByParteRol(String rolUsuBuscar) {
        Query queryJPQL = getEntityManager().createNamedQuery("Usuario.findByRol");
        queryJPQL.setParameter("rol", rolUsuBuscar);
        return queryJPQL.getResultList();
    }
    
    public List<Usuario> findByParteEstado(String estadoUsuBuscar) {
        Query queryJPQL = getEntityManager().createNamedQuery("Usuario.findByEstado");
        queryJPQL.setParameter("estado", estadoUsuBuscar);
        return queryJPQL.getResultList();
    }
    
   
}
