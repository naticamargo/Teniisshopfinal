package edu.co.sena.tennisshop.view.administrador.beans;

import edu.co.sena.tennisshop.modelo.entities.Catalogo;
import edu.co.sena.tennisshop.vista.general.util.JsfUtil;
import edu.co.sena.tennisshop.vista.general.util.JsfUtil.PersistAction;
import edu.co.sena.tennisshop.controler.administrador.beans.CatalogoFacade;

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

@Named("catalogoController")
@SessionScoped
public class CatalogoController implements Serializable {

    @EJB
    private edu.co.sena.tennisshop.controler.administrador.beans.CatalogoFacade ejbFacade;
    private List<Catalogo> items = null;
    private List<Catalogo> itemsBuscados = null;
    private Catalogo selected;
    private Catalogo selectBuscar;
    private Integer IdBuscar;
    private String Nombrebuscar;
    
    

    public CatalogoController() {
    }

    public Catalogo getSelected() {
        return selected;
    }

    public void setSelected(Catalogo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CatalogoFacade getFacade() {
        return ejbFacade;
    }

    public Catalogo prepareCreate() {
        selected = new Catalogo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CatalogoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CatalogoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CatalogoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    public void eliminarBuscado() {
        persist(PersistAction.DELETEBUSCAR, ResourceBundle.getBundle("/Bundle").getString("CatalogoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        itemsBuscados = null;
        selectBuscar = null;

    }
    
     public List<Catalogo> buscarPorId() {
        itemsBuscados = getFacade().finById(IdBuscar);
        Nombrebuscar = null;
        items = null;
        return itemsBuscados;
    }

    public List<Catalogo> buscarPorNombre() {
        itemsBuscados = getFacade().findByNombre(Nombrebuscar);
        items = null;
        IdBuscar = null;
        return itemsBuscados;
    }

    public List<Catalogo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
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

    public Catalogo getCatalogo(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Catalogo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Catalogo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public edu.co.sena.tennisshop.controler.administrador.beans.CatalogoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(edu.co.sena.tennisshop.controler.administrador.beans.CatalogoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<Catalogo> getItemsBuscados() {
        return itemsBuscados;
    }

    public void setItemsBuscados(List<Catalogo> itemsBuscados) {
        this.itemsBuscados = itemsBuscados;
    }

    public Catalogo getSelectBuscar() {
        return selectBuscar;
    }

    public void setSelectBuscar(Catalogo selectBuscar) {
        this.selectBuscar = selectBuscar;
    }

    public Integer getIdBuscar() {
        return IdBuscar;
    }

    public void setIdBuscar(Integer IdBuscar) {
        this.IdBuscar = IdBuscar;
    }

    public String getNombrebuscar() {
        return Nombrebuscar;
    }

    public void setNombrebuscar(String Nombrebuscar) {
        this.Nombrebuscar = Nombrebuscar;
    }

    @FacesConverter(forClass = Catalogo.class)
    public static class CatalogoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CatalogoController controller = (CatalogoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "catalogoController");
            return controller.getCatalogo(getKey(value));
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
            if (object instanceof Catalogo) {
                Catalogo o = (Catalogo) object;
                return getStringKey(o.getIdCatologo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Catalogo.class.getName()});
                return null;
            }
        }

    }

}
