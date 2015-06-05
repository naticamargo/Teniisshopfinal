/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tennisshop.controler.administrador.beans;

import edu.co.sena.tennisshop.modelo.entities.Domicilio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aprendiz
 */
@Stateless
public class DomicilioFacade extends AbstractFacade<Domicilio> {
    @PersistenceContext(unitName = "com.mycompany_TennisshopVersionFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DomicilioFacade() {
        super(Domicilio.class);
    }
    
}