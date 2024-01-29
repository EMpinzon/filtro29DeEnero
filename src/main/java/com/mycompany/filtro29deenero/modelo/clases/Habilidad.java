/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtro29deenero.modelo.clases;

/**
 *
 * @author user
 */
public class Habilidad {
    
    private long ninjaId ;
    private String habilidadNombre;
    private String habilidadDescripcion;

    public Habilidad(long ninjaId, String habilidadNombre, String habilidadDescripcion) {
        this.ninjaId = ninjaId;
        this.habilidadNombre = habilidadNombre;
        this.habilidadDescripcion = habilidadDescripcion;
    }

    public Habilidad() {
    }
    
    
    
    
    
    
    

    public long getNinjaId() {
        return ninjaId;
    }

    public void setNinjaId(long ninjaId) {
        this.ninjaId = ninjaId;
    }

    public String getHabilidadNombre() {
        return habilidadNombre;
    }

    public void setHabilidadNombre(String habilidadNombre) {
        this.habilidadNombre = habilidadNombre;
    }

    public String getHabilidadDescripcion() {
        return habilidadDescripcion;
    }

    public void setHabilidadDescripcion(String habilidadDescripcion) {
        this.habilidadDescripcion = habilidadDescripcion;
    }

    @Override
    public String toString() {
        return "Habilidad{" + "ninjaId=" + ninjaId + ", habilidadNombre=" + habilidadNombre + ", habilidadDescripcion=" + habilidadDescripcion + '}';
    }
    
    
    
    
    
    
}
