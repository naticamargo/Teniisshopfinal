package edu.co.sena.tennisshop.view.administrador.beans;

import edu.co.sena.tennisshop.modelo.entities.Producto;
import edu.co.sena.tennisshop.vista.general.util.JsfUtil;
import edu.co.sena.tennisshop.vista.general.util.JsfUtil.PersistAction;
import edu.co.sena.tennisshop.controler.administrador.beans.ProductoFacade;

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

@Named("productoController")
@SessionScoped
public class ProductoController implements Serializable {

    @EJB
    private edu.co.sena.tennisshop.controler.administrador.beans.ProductoFacade ejbFacade;
    private List<Producto> items = null;
    private List<Producto> itemsBuscados = null;
    private Producto selected;
     private Producto selectBuscar;
    private String idBuscar;
    private String nombreBuscar;
    private  Integer IdCategoria;
    

    public ProductoController() {
    }

    public Producto getSelected() {
        return selected;
    }

    public void setSelected(Producto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProductoFacade getFacade() {
        return ejbFacade;
    }

    public Producto prepareCreate() {
        selected = new Producto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProductoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProductoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProductoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
     public void eliminarBuscado() {
        persist(PersistAction.DELETEBUSCAR, ResourceBundle.getBundle("/Bundle").getString("ProductoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        itemsBuscados = null;
        selectBuscar = null;

    }
    
     public List<Producto> buscarPorId() {
        itemsBuscados = getFacade().finById(idBuscar);
        nombreBuscar = null;
        IdCategoria= null;
        items = null;
        return itemsBuscados;
    }

    public List<Producto> buscarPorNombre() {
        itemsBuscados = getFacade().findByNombre(nombreBuscar);
        items = null;
        idBuscar = null;
        IdCategoria = null;
        return itemsBuscados;
    }

    public List<Producto> buscarPorIdCategoria() {
        itemsBuscados = getFacade().findByIdCategoria(IdCategoria);
        items = null;
        idBuscar = null;
        nombreBuscar = null;
        return itemsBuscados;
    }


    public List<Producto> getItems() {
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

    public Producto getProducto(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Producto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Producto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public edu.co.sena.tennisshop.controler.administrador.beans.ProductoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(edu.co.sena.tennisshop.controler.administrador.beans.ProductoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<Producto> getItemsBuscados() {
        return itemsBuscados;
    }

    public void setItemsBuscados(List<Producto> itemsBuscados) {
        this.itemsBuscados = itemsBuscados;
    }

    public Producto getSelectBuscar() {
        return selectBuscar;
    }

    public void setSelectBuscar(Producto selectBuscar) {
        this.selectBuscar = selectBuscar;
    }

    public String getIdBuscar() {
        return idBuscar;
    }

    public void setIdBuscar(String idBuscar) {
        this.idBuscar = idBuscar;
    }

    public String getNombreBuscar() {
        return nombreBuscar;
    }

    public void setNombreBuscar(String nombreBuscar) {
        this.nombreBuscar = nombreBuscar;
    }

    public Integer getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(Integer IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    @FacesConverter(forClass = Producto.class)
    public static class ProductoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductoController controller = (ProductoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productoController");
            return controller.getProducto(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Producto) {
                Producto o = (Producto) object;
                return getStringKey(o.getIdProducto());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Producto.class.getName()});
                return null;
            }
        }

    }

}
