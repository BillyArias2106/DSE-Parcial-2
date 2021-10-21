/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.managedbean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.dao.DatosEmpleadosDAO;
import sv.edu.udb.hibernate.Datosempleados;

@ManagedBean
@SessionScoped

public class EmpleadoBean {
    
        private Datosempleados empleado;
        public EmpleadoBean() {
        empleado = new Datosempleados();
        }
        public void addEmpleado( ){
        DatosEmpleadosDAO empleadoDao = new DatosEmpleadosDAO();
        empleadoDao.addEmpleado(getEmpleado());

        FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage("Empleado con ID " + this.empleado.getId() + "Agregado" ));

        this.empleado = new Datosempleados();
        }

        public void returnEmpleadoId(){
        DatosEmpleadosDAO empleadoDao = new DatosEmpleadosDAO();
        Datosempleados tmp = empleadoDao.getEmpleadoID(this.empleado.getId()) ;

        this.empleado = tmp;
        if(empleado == null){
        FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage("Cliente NO especificado"));

        this.empleado = new Datosempleados();
        }

        }

        public String deleteEmpleado(){
        DatosEmpleadosDAO empleadoDao = new DatosEmpleadosDAO();
        Datosempleados obtempleado =
        empleadoDao.getEmpleadoID(this.empleado.getId());

        if(obtempleado != null){
        empleadoDao.deleteEmpleado(this.empleado.getId());

        FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage("Cliente con ID " + this.empleado.getId() + "Eliminado" ));

        }else{
        FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage("Cliente con ID " + this.empleado.getId() + " NO encontrado" ));
        }

        this.empleado = new Datosempleados();
        return "Empleado";

        }
        public String updateEmpleado(){
        DatosEmpleadosDAO empleadoDao = new DatosEmpleadosDAO();
        Datosempleados obtempleado =
        empleadoDao.getEmpleadoID(this.empleado.getId());

        if(obtempleado != null){

        empleadoDao.updateEmpleado(this.empleado);
        FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage("Empleado con ID " + this.empleado.getId() + "Actualizado" ));

        }else{

        FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage("Empleado con ID " + this.empleado.getId() + " NO encontrado" ));
        }

        this.empleado = new Datosempleados();
        return "Empleado";

        }
        public List<Datosempleados> getEmpleados(){
        DatosEmpleadosDAO empleadoDao = new DatosEmpleadosDAO();
        List<Datosempleados> lista = empleadoDao.obtenerEmpleados();
        return lista;
        }
        /**
        * @return the empleado
        */
        public Datosempleados getEmpleado() {
        return empleado;
        }
        /**
        * @param empleado the empleado to set
        */
        public void setEmpleado(Datosempleados empleado) {
        this.empleado = empleado;
        }
       }
