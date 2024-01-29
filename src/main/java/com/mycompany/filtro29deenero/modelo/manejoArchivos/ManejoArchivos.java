/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtro29deenero.modelo.manejoArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author user
 */
public class ManejoArchivos {
    
    
    public static void leerArchivo(String ruta){
    
        try(BufferedReader buffer = new BufferedReader( new FileReader(new File( ruta )) )){
            String linea;
            
            while( (linea = buffer.readLine()) != null ){
                    
                System.out.println(linea);
            }
            
        
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void escribirArchivo (String ruta , String linea){
    
        try(PrintWriter writer = new PrintWriter( new FileWriter(new File( ruta )) )){

          writer.println( linea );

        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }
    
}
