/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtro29deenero.modelo.operaciones;

import com.mycompany.filtro29deenero.modelo.clases.Habilidad;
import com.mycompany.filtro29deenero.modelo.clases.Mision;
import com.mycompany.filtro29deenero.modelo.clases.Ninja;
import com.mycompany.filtro29deenero.modelo.clases.Rango;
import com.mycompany.filtro29deenero.modelo.persistencia.ConexionDB;
import com.mycompany.filtro29deenero.modelo.persistencia.OperacionesDB;
import java.sql.PreparedStatement;

/**
 *
 * @author user
 */
public class EntidadesOperaciones {
    
    public boolean crearMision(   Mision mision  ){
        
        OperacionesDB.setConnection(ConexionDB.MySQLConnection());
        String sentencia = "insert into mision (descripcion, rango , recompensa ) values (   )";
        
        try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
            ps.setString(1, mision.getMisionDescripcion());
            ps.setString(2, mision.getMisionRango().getNombre());
            ps.setInt(3, mision.getMisionRecompensa());
            int rs = OperacionesDB.insertar_actualizar_borrar_BD(ps);
            
            if(rs>0){
                return true;
                
            }else{
                System.out.println("no se pudo insertar la informacion");
                return false;
            }
            
        
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean crearNinja (Ninja ninja ){
    
        OperacionesDB.setConnection(ConexionDB.MySQLConnection());
        String sentencia = "insert into ninja (nombre, rango , aldea ) values (  )";
        
        try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
            ps.setString(1, ninja.getNombre());           
            ps.setString(2, ninja.getNinjaRango().getNombre());   
            ps.setString(3, ninja.getNinjaAldea().getNombre());
            int rs = OperacionesDB.insertar_actualizar_borrar_BD(ps);
            
            if(rs>0){
                return true;
                
            }else{
                System.out.println("no se pudo insertar la informacion");
                return false;
            }
            
        
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
        return false;
    
    }
    
    public boolean borrarNinja (  long ninjaId){
    
    OperacionesDB.setConnection(ConexionDB.MySQLConnection());
    String sentencia = "delete from  ninja where id = ?";
        
    try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
          ps.setLong(1, ninjaId);           
          int rs = OperacionesDB.insertar_actualizar_borrar_BD(ps);

          if(rs>0){
              return true;

          }else{
              System.out.println("no se pudo borrar la informacion");
              return false;
          }


      }catch(Exception e ){
          System.out.println(e.getMessage());
      }
      return false;   
    
    
    }
    
    
    public boolean borrarMision (  long misionId){
    
    OperacionesDB.setConnection(ConexionDB.MySQLConnection());
    String sentencia = "delete from  mision where id = ?";
        
    try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
          ps.setLong(1, misionId);           
          int rs = OperacionesDB.insertar_actualizar_borrar_BD(ps);

          if(rs>0){
              return true;

          }else{
              System.out.println("no se pudo borrar la informacion");
              return false;
          }


      }catch(Exception e ){
          System.out.println(e.getMessage());
      }
      return false;   
    
    
    }
    
    
    public boolean crearHabilidad (Habilidad habilidad ){
    
        OperacionesDB.setConnection(ConexionDB.MySQLConnection());
        String sentencia = "insert into habilidad  values ( ? , ? ,? )";
        
        try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
            
            ps.setLong(1, habilidad.getNinjaId());
            ps.setString(2, habilidad.getHabilidadNombre());
            ps.setString(3, habilidad.getHabilidadDescripcion());
            
            int rs = OperacionesDB.insertar_actualizar_borrar_BD(ps);
            
            if(rs>0){
                return true;
                
            }else{
                System.out.println("no se pudo insertar la informacion");
                return false;
            }
            
        
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
        return false;
    
    }
    
    
    
    public boolean borrarHabilidad (  String habilidadNombre ){
    
    OperacionesDB.setConnection(ConexionDB.MySQLConnection());
    String sentencia = "delete from  habilidad where nombre = ?";
        
    try(PreparedStatement ps = OperacionesDB.getConnection().prepareStatement(sentencia)){
          ps.setString(1, habilidadNombre);           
          int rs = OperacionesDB.insertar_actualizar_borrar_BD(ps);

          if(rs>0){
              return true;

          }else{
              System.out.println("no se pudo borrar la informacion");
              return false;
          }


      }catch(Exception e ){
          System.out.println(e.getMessage());
      }
      return false;   
    
    
    }
    
}
