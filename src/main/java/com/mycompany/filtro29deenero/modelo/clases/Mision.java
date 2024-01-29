/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtro29deenero.modelo.clases;

import com.mycompany.filtro29deenero.modelo.clases.Rango;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Mision {
    
    
    private long misionId;
    private String misionDescripcion;
    private Rango misionRango;
    private int misionRecompensa;


    public Mision(long misionId, String misionDescripcion, Rango misionRango, int misionRecompensa) {
        this.misionId = misionId;
        this.misionDescripcion = misionDescripcion;
        this.misionRango = misionRango;
        this.misionRecompensa = misionRecompensa;

    }

    public Mision() {
    }
    
    
    
    

    public long getMisionId() {
        return misionId;
    }

    public void setMisionId(long misionId) {
        this.misionId = misionId;
    }

    public String getMisionDescripcion() {
        return misionDescripcion;
    }

    public void setMisionDescripcion(String misionDescripcion) {
        this.misionDescripcion = misionDescripcion;
    }

    public Rango getMisionRango() {
        return misionRango;
    }

    public void setMisionRango(Rango misionRango) {
        this.misionRango = misionRango;
    }
    
    public void setMisionRango(String misionRango) {
        Rango rango = null;
        
        if( misionRango.equalsIgnoreCase("amateur") ){
            rango = Rango.AMATEUR;
        }
        if( misionRango.equalsIgnoreCase("novato") ){
            rango = Rango.NOVATO;
        }
        if( misionRango.equalsIgnoreCase("intermedio") ){
            rango = Rango.INTERMEDIO;
        }
        if( misionRango.equalsIgnoreCase("experto") ){
            rango = Rango.EXPERTO;
        }
        if( misionRango.equalsIgnoreCase("leyenda") ){
            rango = Rango.LEYENDA;
        }
        this.misionRango = rango;
    }
    

    public int getMisionRecompensa() {
        return misionRecompensa;
    }

    public void setMisionRecompensa(int misionRecompensa) {
        this.misionRecompensa = misionRecompensa;
    }

    @Override
    public String toString() {
        return "Mision{" + "misionId=" + misionId + ", misionDescripcion=" + misionDescripcion + ", misionRango=" + misionRango.getNombre() + ", misionRecompensa=" + misionRecompensa + '}';
    }
    
    
    
}
