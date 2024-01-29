/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.filtro29deenero;

/**
 *
 * @author user
 */
public enum Rango {
    
    AMATEUR("amateur"),NOVATO("novato"),INTERMEDIO("intermedio"),EXPERTO("experto"),LEYENDA("leyenda");
    
    private String nombre;
    
    private Rango(String nombre ){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
}
