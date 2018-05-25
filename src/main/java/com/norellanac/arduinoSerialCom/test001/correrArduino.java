/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norellanac.arduinoSerialCom.test001;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
/**
 *
 * @author norellanac
 */

//**********esta clase envia y recibe un dato************
public class correrArduino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Se crea una variable tipo PanamaHitek_Arduino
    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    //Se crea un eventListener para el puerto serie
    SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        //Si se recibe algun dato en el puerto serie, se ejecuta el siguiente metodo
        public void serialEvent(SerialPortEvent serialPortEvent) {
            try {
                //ino.sendData("1R");
                /*
                Los datos en el puerto serie se envian caracter por caracter. Si se
                desea esperar a terminar de recibir el mensaje antes de imprimirlo, 
                el metodo isMessageAvailable() devolvera TRUE cuando se haya terminado
                de recibir el mensaje, el cual podra ser impreso a traves del metodo
                printMessage()
                 */
                if (ino.isMessageAvailable()) {
                    //Se recibe el dato y se le asigna al jLabelAnswer
                    System.out.println(ino.printMessage());
                    ino.sendData("1R");
                    ino.killArduinoConnection();
                }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(arduinoNerytest001.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
        
    //***inicia la conxion usando el istener que tiene arametros para leer un mensaje
    //initComponents();
        //Se inicia la conexion con el puerto serie COM20 a 9600 baudios
        try {
            ino.arduinoRXTX("/dev/ttyACM0", 9600, listener);
           
        } catch (ArduinoException ex) {
            Logger.getLogger(arduinoNerytest001.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //********intenta enviar dato*********
         try {
                //Se envia el contenido por el puerto serie al Arduino
                ino.sendData("5");
            } catch (ArduinoException | SerialPortException ex) {
                Logger.getLogger(arduinoNerytest001.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
