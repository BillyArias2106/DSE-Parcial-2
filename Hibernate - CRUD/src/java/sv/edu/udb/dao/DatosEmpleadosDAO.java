/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.hibernate.Datosempleados;
import sv.edu.udb.hibernate.HibernateUtil;

public class DatosEmpleadosDAO {
    public void addEmpleado(Datosempleados empleados){
        
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try   
        {
            tra=ses.beginTransaction();
            ses.save(empleados);
            ses.getTransaction().commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            if ( tra != null )
            {
                tra.rollback();
            }
        }
        finally
        {
            ses.flush();
            ses.close();
        }
 }
        public void deleteEmpleado(Integer idEmpleado){
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try 
        {
            tra=ses.beginTransaction();
            Datosempleados empleado = (Datosempleados)
            ses.get(Datosempleados.class,idEmpleado);
            ses.delete(empleado);
            ses.getTransaction().commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }
        finally
        {
            ses.flush();
            ses.close();
        }

 }
        public void updateEmpleado(Datosempleados empleado){
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
        tra=ses.beginTransaction();

        ses.update(empleado);
        ses.getTransaction().commit();
        } catch (Exception e) {
        e.printStackTrace();
        if ( tra != null ){
        tra.rollback();
        }
        }finally{
        ses.flush();
        ses.close();
        }
        }

        public Datosempleados getEmpleadoID(Integer idEmpleado){
            Datosempleados empleado = null;
            SessionFactory sesFact = HibernateUtil.getSessionFactory();
            Session ses = sesFact.openSession();
            Transaction tra = null;
            try {
                tra=ses.beginTransaction();
                String queryString = "from Datosempleados where id = :idFind";
                Query query = ses.createQuery(queryString);
                query.setParameter("idFind", idEmpleado);
                empleado = (Datosempleados) query.uniqueResult();
            } 
            catch (HibernateException e) {
                e.printStackTrace();
                if ( tra != null ){
                tra.rollback();
            }
            }finally{
                ses.flush();
                ses.close();
            }
        return empleado;
        }

        public List<Datosempleados> obtenerEmpleados(){
        List<Datosempleados> empleados = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
        tra=ses.beginTransaction();
        String queryString = "from Datosempleados";
        Query query = ses.createQuery(queryString);
        empleados= query.list();

        } catch (HibernateException e) {
        e.printStackTrace();
        if ( tra != null ){
        tra.rollback();
        }
        }finally{
        ses.flush();
        ses.close();
        }
        return empleados;
        }

       }
