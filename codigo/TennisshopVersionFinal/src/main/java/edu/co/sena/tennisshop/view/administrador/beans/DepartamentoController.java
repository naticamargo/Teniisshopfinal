package edu.co.sena.tennisshop.view.administrador.beans;

import edu.co.sena.tennisshop.modelo.entities.Departamento;
import edu.co.sena.tennisshop.vista.general.util.JsfUtil;
import edu.co.sena.tennisshop.vista.general.util.JsfUtil.PersistAction;
import edu.co.sena.tennisshop.controler.administrador.beans.DepartamentoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;

@Named("departamentoController")
@ViewScoped
public class DepartamentoController implements Serializable {

    @EJB
    private edu.co.sena.tennisshop.controler.administrador.beans.DepartamentoFacade ejbFacade;
    private List<Departamento> items = null;
    private List<Departamento> itemsBuscados = null;
    private Departamento selected;
    private Departamento selectBuscar;
    private Integer idBuscar;
    private String nombreBuscar;

    public DepartamentoController() {
    }

    public Departamento getSelected() {
        return selected;
    }

    public void setSelected(Departamento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DepartamentoFacade getFacade() {
        return ejbFacade;
    }

    public Departamento prepareCreate() {
        selected = new Departamento();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DepartamentoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DepartamentoUpdated"));
    }

    public void updateBuscar() {
        persist(PersistAction.UPDATEBUSCAR, ResourceBundle.getBundle("/Bundle").getString("DepartamentoUpdated"));
        items = null;
        selected = null;
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DepartamentoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void eliminarBuscado() {
        persist(PersistAction.DELETEBUSCAR, ResourceBundle.getBundle("/Bundle").getString("DepartamentoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        itemsBuscados = null;
        selectBuscar = null;
    }

    public List<Departamento> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
public List<Departamento> buscarPorId() {
        itemsBuscados = getFacade().finById(idBuscar);
        nombreBuscar = null;
        items = null;
        return itemsBuscados;
    }

    public List<Departamento> buscarPorNombre() {
        itemsBuscados = getFacade().findByParteNombre(nombreBuscar);
        items = null;
        idBuscar = null;
        return itemsBuscados;
    }
    
    public List<Departamento> getItemsBuscados() {

        if (itemsBuscados == getFacade().finById(idBuscar)) {
            return itemsBuscados;
        }
        return null;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
            if (selectBuscar != null) {
                setEmbeddableKeys();
                try {
                    if (persistAction != PersistAction.DELETEBUSCAR) {
                        getFacade().edit(selectBuscar);
                    } else {
                        getFacade().remove(selectBuscar);
                    }
                    JsfUtil.addSuccessMessage(successMessage);
                } catch (EJBException ex) {
                    String msg = "";
                    Throwable cause = ex.getCause();
                    if (cause != null) {
                        msg = cause.getLocalizedMessage();
                    }
                    if (msg.length() > 0) {
                        JsfUtil.addErrorMessage(msg);
                    } else {
                        JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }

            }
        }
    }

    public Departamento getDepartamento(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Departamento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Departamento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public edu.co.sena.tennisshop.controler.administrador.beans.DepartamentoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(edu.co.sena.tennisshop.controler.administrador.beans.DepartamentoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public int getIdbuscar() {
        return idBuscar;
    }

    public void setIdbuscar(Integer idbuscar) {
        this.idBuscar = idbuscar;
    }

    public Departamento getSelectBuscar() {
        return selectBuscar;
    }

    public void setSelectBuscar(Departamento selectBuscar) {
        this.selectBuscar = selectBuscar;
    }

    @FacesConverter(forClass = Departamento.class)
    public static class DepartamentoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DepartamentoController controller = (DepartamentoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "departamentoController");
            return controller.getDepartamento(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Departamento) {
                Departamento o = (Departamento) object;
                return getStringKey(o.getIdDEPARTAMENTO());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Departamento.class.getName()});
                return null;
            }
        }

    }

}
