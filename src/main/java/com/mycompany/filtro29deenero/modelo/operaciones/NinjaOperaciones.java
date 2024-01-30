/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtro29deenero.modelo.operaciones;

import com.mycompany.filtro29deenero.modelo.clases.Mision;
import com.mycompany.filtro29deenero.modelo.clases.Ninja;
import com.mycompany.filtro29deenero.modelo.manejoArchivos.ManejoArchivos;
import com.mycompany.filtro29deenero.modelo.persistencia.ConexionDB;
import com.mycompany.filtro29deenero.modelo.persistencia.OperacionesDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class NinjaOperaciones {
    


    public List<Ninja> listarNinjas(){
    
        OperacionesDB.setConnection(ConexionDB.MySQLConnection());
        String sentencia = "select * from ninja";
        try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
            List<Ninja> ninjasResultado = new ArrayList<>();
            ResultSet rs = OperacionesDB.consultar_BD(ps);
            while(rs.next()){
                long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String rango = rs.getString("rango");
                String aldea = rs.getString("aldea");
                
                Ninja ninja = new Ninja();
                
                ninja.setNinjaId(id);
                ninja.setNombre(nombre);
                ninja.setNinjaRango(rango);
                ninja.setNinjaAldea(aldea);
                
                ninjasResultado.add(ninja);
            }
            
            return ninjasResultado;
        
        }
        catch(Exception e ){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
    public Ninja consultarNinja(long id){
    
        OperacionesDB.setConnection(ConexionDB.MySQLConnection());
        String sentencia = "select * from ninja where id = ? ;";
        try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
            Ninja ninja = new Ninja();
            ps.setLong(1, id);
            ResultSet rs = OperacionesDB.consultar_BD(ps);
            while(rs.next()){
                long sqlId = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String rango = rs.getString("rango");
                String aldea = rs.getString("aldea");

                ninja.setNinjaId(id);
                ninja.setNombre(nombre);
                ninja.setNinjaRango(rango);
                ninja.setNinjaAldea(aldea);

            }
            
            return ninja;
        
        }
        catch(Exception e ){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
    
    
    
    public void listarMisionesPorNinja( int id){
    
        Ninja ninja ;
        ninja =  consultarNinja(id);
        
        if(ninja != null){
            OperacionesDB.setConnection(ConexionDB.MySQLConnection());
            String sentencia = "select * from mision_ninja  where idNinja = ?;" ;
            try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
                ps.setLong(1, ninja.getNinjaId());
                ResultSet rs = OperacionesDB.consultar_BD(ps);
                System.out.println("el ninja con el nombre " + ninja.getNombre() + " tiene o ha tenido las siguientes misiones : " );
                while(rs.next()){

                    String sentenciaMision = "select * from mision  where id = ?;" ;
                    PreparedStatement psm = OperacionesDB.getConnection().prepareStatement(sentenciaMision);
                    psm.setLong(1, rs.getLong("idMision"));
                    rs = OperacionesDB.consultar_BD(psm);

                    while(rs.next()){

                        System.out.println(rs.getString("descripcion") + " que tiene el rango : " + rs.getString("rango") 
                                + " con una recompensa de " + rs.getInt("recompensa") + "\n");

                    }

                }  
            }
            catch(Exception e ){
                System.out.println(e.getMessage());
            }
        }
        
        
        
    }
    
    
    public void listarMisionesCompletadasPorNinja(int id){
    
        Ninja ninja ;
        ninja =  consultarNinja(id);
        
        if(ninja != null){
            OperacionesDB.setConnection(ConexionDB.MySQLConnection());
            String sentencia = "select * from mision_ninja  where idNinja = ?;" ;
            try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
                ps.setLong(1, ninja.getNinjaId());
                ResultSet rs = OperacionesDB.consultar_BD(ps);
                System.out.println("el ninja con el nombre " + ninja.getNombre() + "  tiene la siguientes misiones finalizadas : " );
                while(rs.next()){

                    String sentenciaMision = "select * from mision  where id = ?;" ;
                    PreparedStatement psm = OperacionesDB.getConnection().prepareStatement(sentenciaMision);
                    psm.setLong(1, rs.getLong("idMision"));
                    rs = OperacionesDB.consultar_BD(psm);

                    while(rs.next()){

                        if (   rs.getString("fechaFin") != null ){
                    
                            System.out.println(rs.getString("descripcion") + " que tiene el rango : " + rs.getString("rango") 
                                + " con una recompensa de " + rs.getInt("recompensa") + "\n");
                        }
                        
                    }

                }  
            }
            catch(Exception e ){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    public List<Mision> listarMisiones(){
    
       OperacionesDB.setConnection(ConexionDB.MySQLConnection());
        String sentencia = "select * from mision;";
        try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
            List<Mision> misionResultado = new ArrayList<>();
            ResultSet rs = OperacionesDB.consultar_BD(ps);
            while(rs.next()){
                long id = rs.getLong("id");
                String descripcion = rs.getString("descripcion");
                String rango = rs.getString("rango");
                int recompensa = rs.getInt("recompensa");
                
                Mision mision = new Mision();
                
                mision.setMisionId(id);
                mision.setMisionRango(rango);
                mision.setMisionRecompensa(recompensa);
                mision.setMisionDescripcion(descripcion);
                
                misionResultado.add(mision);
                
            }
            
            return misionResultado;
        
        }
        catch(Exception e ){
            System.out.println(e.getMessage());
        }
        return null;
    
    }
    
    
    
    public boolean asignarMision( long ninjaId, long misionId, LocalDate fecha ){
        
        if(!verificarAsignacion(ninjaId, misionId)){
            System.out.println("el registro que intentas guardar ya existe");
            return false;
        }
     
        OperacionesDB.setConnection(ConexionDB.MySQLConnection());
        String sentencia = "insert into mision_ninja (idNinja, idMision, fechaInicio) values( ? ,? ,? ) ;" ;
        try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
            ps.setLong(1, ninjaId);
            ps.setLong(2, misionId);
            ps.setString(3, fecha.toString());
            int rs = OperacionesDB.insertar_actualizar_borrar_BD(ps);
            if(rs>0){
                    return true;
                
            }else{
                System.out.println("no se pudo insertar la informacion");
            }
        
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
        
        return false;
     
    }
    
    public boolean asignarMisionComoCompletada( long ninjaId, long misionId, LocalDate fecha ){
        
        if( verificarAsignacion(ninjaId, misionId) ){
            System.out.println("la mision que quieres confirmar como completada no ha sido asignada a ese ninja");
            return false;
        }
        
        if( !verificarMisionCompletada(ninjaId, misionId)){
            return false;
        }
        
        
        OperacionesDB.setConnection(ConexionDB.MySQLConnection());
        String sentencia = "update mision_ninja set fechaFin = ? where idNinja = ? and  idMision  = ? ;" ;
        try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
            ps.setString(1, fecha.toString());
            ps.setLong(2, ninjaId);
            ps.setLong(3, misionId);
            
            int rs = OperacionesDB.insertar_actualizar_borrar_BD(ps);
            if(rs>0){
                
                String sentenciaMision = "select * from mision  where id = ?;" ;
                PreparedStatement psm = OperacionesDB.getConnection().prepareStatement(sentenciaMision);
                psm.setLong(1, misionId);
                ResultSet rsm = OperacionesDB.consultar_BD(psm);
                if(rsm != null){
                    while(rsm.next()){
                        ManejoArchivos.escribirArchivo( "archivoMisiones.txt", rsm.getString("nombre") + "/" + rsm.getString("descripcion")  );    
                        return true;
                    }                    
                }
            }else{
                System.out.println("no se pudo insertar la informacion");
            }
        
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
        
        return false;
    
    }
    
     public void listarMisionesCompletas() {
     
         ManejoArchivos.leerArchivo("archivoMisiones.txt");
         
     }
     
     
     
    
    public boolean verificarAsignacion( long ninjaId, long misionId){

        OperacionesDB.setConnection(ConexionDB.MySQLConnection());
        String sentencia = "select * from mision_ninja" ;
        try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
            ResultSet rs =OperacionesDB.consultar_BD(ps);
            if(rs!=null){
                while (rs.next()) {

                    if( ninjaId == rs.getLong("idNinja") && misionId == rs.getLong("idMision")){

                        return false;
                    }
                }
                return true;
            }else{
                System.out.println("no se puedo verificar la tabla mision_ninja");

            }

        }catch(Exception e ){
            System.out.println(e.getMessage());

        }
        return false;
    } 


    public boolean verificarMisionCompletada( long ninjaId, long misionId ){

        OperacionesDB.setConnection(ConexionDB.MySQLConnection());
        String sentencia = "select fechaFin from mision_ninja where idNinja = ? and idMision = ?  ;" ;
        try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
            
            ps.setLong(1,ninjaId);
            ps.setLong(2, misionId);
            ResultSet rs = OperacionesDB.consultar_BD(ps);
            if(rs !=  null){
                while( rs.next() ){    
                    if( rs.getString("fechaFin") != null  ){
                       System.out.println("este mision para este ninja ya esta completada");
                       return false;
                    }
               } 
               return true;                
            }
        }catch(Exception e ){
            System.out.println(e.getMessage());

        }
        return false;
    }

    
}

