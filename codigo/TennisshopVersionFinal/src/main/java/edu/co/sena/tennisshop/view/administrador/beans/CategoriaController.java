package edu.co.sena.tennisshop.view.administrador.beans;

import edu.co.sena.tennisshop.modelo.entities.Categoria;
import edu.co.sena.tennisshop.vista.general.util.JsfUtil;
import edu.co.sena.tennisshop.vista.general.util.JsfUtil.PersistAction;
import edu.co.sena.tennisshop.controler.administrador.beans.CategoriaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;

@Named("categoriaController")
@ViewScoped
public class CategoriaController implements Serializable {

    @EJB
    private edu.co.sena.tennisshop.controler.administrador.beans.CategoriaFacade ejbFacade;
    private List<Categoria> items = null;
    private List<Categoria> itemsbuscados=null;
    private Categoria selected;
    private Categoria selectBuscar;
    
    private Integer idBuscar;
    private String nombreBuscar;
    

    public CategoriaController() {
    }

    public Categoria getSelected() {
        return selected;
    }

    public void setSelected(Categoria selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CategoriaFacade getFacade() {
        return ejbFacade;
    }

    public Categoria prepareCreate() {
        selected = new Categoria();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CategoriaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CategoriaUpdated"));
        selectBuscar = null;
        itemsbuscados = null;
    }
    public void updateBuscar(){
        persist(PersistAction.UPDATEBUSCAR, ResourceBundle.getBundle("/Bundle").getString("CategoriaUpdated"));
        items = null;
        selected = null;
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CategoriaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
  public void eliminarBuscado(){
      persist(PersistAction.DELETEBUSCAR, ResourceBundle.getBundle("/Bundle").getString("CategoriaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        itemsbuscados = null;
        selectBuscar = null;
  }
    public List<Categoria> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    public List<Categoria> buscarporId(){
        itemsbuscados = getFacade().findById(idBuscar);
        nombreBuscar = null;
        items = null;
        return itemsbuscados;
    }
    public List<Categoria> buscarPorNombre() {
        itemsbuscados = getFacade().findByParteNombre(nombreBuscar);
        items = null;
        idBuscar = null;
        return itemsbuscados;
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
        }
    }

    public Categoria getCategoria(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Categoria> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Categoria> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public edu.co.sena.tennisshop.controler.administrador.beans.CategoriaFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(edu.co.sena.tennisshop.controler.administrador.beans.CategoriaFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<Categoria> getItemsbuscados() {
        return itemsbuscados;
    }

    public void setItemsbuscados(List<Categoria> itemsbuscados) {
        this.itemsbuscados = itemsbuscados;
    }

    public Categoria getSelectedBuscar() {
        return selectBuscar;
    }

    public void setSelectedBuscar(Categoria selectedBuscar) {
        this.selectBuscar = selectedBuscar;
    }

    public Categoria getSelectBuscar() {
        return selectBuscar;
    }

    public void setSelectBuscar(Categoria selectBuscar) {
        this.selectBuscar = selectBuscar;
    }

    public Integer getIdBuscar() {
        return idBuscar;
    }

    public void setIdBuscar(Integer idBuscar) {
        this.idBuscar = idBuscar;
    }

    public String getNombreBuscar() {
        return nombreBuscar;
    }

    public void setNombreBuscar(String nombreBuscar) {
        this.nombreBuscar = nombreBuscar;
    }

    @FacesConverter(forClass = Categoria.class)
    public static class CategoriaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CategoriaController controller = (CategoriaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "categoriaController");
            return controller.getCategoria(getKey(value));
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
            if (object instanceof Categoria) {
                Categoria o = (Categoria) object;
                return getStringKey(o.getIdCategoria());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Categoria.class.getName()});
                return null;
            }
        }

    }

}
