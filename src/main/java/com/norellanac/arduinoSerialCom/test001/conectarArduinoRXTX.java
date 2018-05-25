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
public class conectarArduinoRXTX {
    //Se crea una instancia de la librería PanamaHitek_Arduino
    private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private static final SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ino.isMessageAvailable()) {
                    //Se imprime el mensaje recibido en la consola
                    System.out.println(ino.printMessage());
                }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(conectarArduinoRXTX.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    };

    public static void main(String[] args) {
        try {
            ino.arduinoRXTX("/dev/ttyACM0", 9600, listener);
            ino.sendData("@");/*
            ino.sendData("2R");
            ino.sendData("3R");
            ino.sendData("4R");*/
            ino.sendByte(64);
            
            System.out.println(ino.getSerialPorts());
            System.out.println(ino.printMessage());
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(conectarArduinoRXTX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
