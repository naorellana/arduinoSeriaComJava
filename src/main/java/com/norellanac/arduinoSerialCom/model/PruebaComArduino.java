/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norellanac.arduinoSerialCom.model;

/**
 *
 * @author norellanac
 */
public class PruebaComArduino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        serialComArduino comArduino= new serialComArduino();
        comArduino.enviaDatoArduino("1R");
    }
    
}
