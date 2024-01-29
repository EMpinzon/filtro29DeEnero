/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.filtro29deenero.modelo.clases;

/**
 *
 * @author user
 */
public enum Aldea {
    
    ALDEA_DE_LA_HOJA("aldea de la hoja"),ALDEA_DE_LA_LLUVIA("aldea de la lluvia"),
    ALDEA_DE_LA_ARENA("aldea de la arena"),ALDEA_DE_LA_NIEBLA("aldea de la niebla");
    
    private String nombre;
    
    private Aldea(String nombre ){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
