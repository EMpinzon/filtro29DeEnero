/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.filtro29deenero.vista;

import com.mycompany.filtro29deenero.modelo.operaciones.NinjaOperaciones;

/**
 *
 * @author user
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        NinjaOperaciones ninjaOperaciones = new NinjaOperaciones();
        
        ninjaOperaciones.listarMisionesPorNinja(2);
        
        
        
    }
    
}
