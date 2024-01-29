/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtro29deenero.modelo.clases;

import com.mycompany.filtro29deenero.modelo.clases.Rango;

/**
 *
 * @author user
 */
public class Ninja {
    
    private long ninjaId;
    
    private Rango ninjaRango;
    
    private String ninjaNombre;
    
    private Aldea ninjaAldea;

    public Ninja(long ninjaId, Rango ninjaRango, String ninjaNombre, Aldea ninjaAldea) {
        this.ninjaId = ninjaId;
        this.ninjaRango = ninjaRango;
        this.ninjaNombre = ninjaNombre;
        this.ninjaAldea = ninjaAldea;
    }

    

    public Ninja() {
    }

    public String getNombre() {
        return ninjaNombre;
    }

    public void setNombre(String nombre) {
        this.ninjaNombre = nombre;
    }
    


    public long getNinjaId() {
        return ninjaId;
    }

    public void setNinjaId(long ninjaId) {
        this.ninjaId = ninjaId;
    }

    public Rango getNinjaRango() {
        return ninjaRango;
    }

    public void setNinjaRango(Rango ninjaRango) {
        this.ninjaRango = ninjaRango;
    }
    
    public void setNinjaRango(String ninjaRango) {
        Rango rango = null;
        
        if( ninjaRango.equalsIgnoreCase("amateur") ){
            rango = Rango.AMATEUR;
        }
        if( ninjaRango.equalsIgnoreCase("novato") ){
            rango = Rango.NOVATO;
        }
        if( ninjaRango.equalsIgnoreCase("intermedio") ){
            rango = Rango.INTERMEDIO;
        }
        if( ninjaRango.equalsIgnoreCase("experto") ){
            rango = Rango.EXPERTO;
        }
        if( ninjaRango.equalsIgnoreCase("leyenda") ){
            rango = Rango.LEYENDA;
        }
        this.ninjaRango = rango;
    }

    public Aldea getNinjaAldea() {
        return ninjaAldea;
    }

    public void setNinjaAldea(Aldea ninjaAldea) {
        this.ninjaAldea = ninjaAldea;
    }
    
     public void setNinjaAldea(String ninjaAldea) {
        Aldea aldea = null;
        
        if( ninjaAldea.equalsIgnoreCase("aldea de la hoja") ){
            aldea = Aldea.ALDEA_DE_LA_HOJA;
        }
        if( ninjaAldea.equalsIgnoreCase("aldea de la arena") ){
            aldea = Aldea.ALDEA_DE_LA_ARENA;
        }
        if( ninjaAldea.equalsIgnoreCase("aldea de la lluvia") ){
            aldea = Aldea.ALDEA_DE_LA_LLUVIA;
        }
        if( ninjaAldea.equalsIgnoreCase("aldea de la niebla") ){
            aldea = Aldea.ALDEA_DE_LA_NIEBLA;
        }
        
        this.ninjaAldea = aldea; 
         
         
    }

    @Override
    public String toString() {
        return "Ninja{" + "ninjaId=" + ninjaId + ", ninjaRango=" + ninjaRango.getNombre() + ", ninjaNombre=" + ninjaNombre + ", ninjaAldea=" + ninjaAldea.getNombre() + '}';
    }
    
    
     
     
    
}
