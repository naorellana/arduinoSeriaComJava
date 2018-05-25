/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norellanac.arduinoSerialCom.test001;

/**
 *
 * @author norellanac
 */

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
public class JavaRX_multiTest001 {

    /**
     * @param args the command line arguments
     */


    //Se crea una instancia de la librería PanamaHitek_Arduino
    private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private static PanamaHitek_MultiMessage multi = new PanamaHitek_MultiMessage(5, ino);
    private static final SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {

                /*
                Aquí es donde se reciben los datos
                multi.dataReceptionCompleted() devuelve TRUE cuando se ha recibido
                los datos de todos los sensores
                 */
                //ino.sendData("5");
                if (multi.dataReceptionCompleted()) {
                    /*
                     * Con multi.getMessage() se leen los datos de los sensores
                     * Los numeros 0, 1 y 2 son los índices de los sensores, los
                     * cuales han sido impresos en ese mismo orden en el Arduino
                     * utilizando Serial.println(). Si no se usa
                     * Serial.println(), la clase MultiMessage no funcionará.
                     *
                     * A pesar de que en la instancia de la clase se colocaron 3
                     * sensores, los índices son 0, 1 y 2 porque se cuenta desde
                     * el cero.
                     */
                    System.out.println("Valor de a --> " + multi.getMessage(0));
                    System.out.println("Valor de b --> " + multi.getMessage(1));
                    System.out.println("Valor de c --> " + multi.getMessage(2));
                     System.out.println("Valor de c --> " + multi.getMessage(3));
                      System.out.println("Valor de c --> " + multi.getMessage(4));
                    System.out.println("-----------------------------------");
                    multi.flushBuffer();
                }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(JavaRX_multiTest001.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    };

    public static void main(String[] args) {
        try {
            ino.arduinoRXTX("/dev/ttyACM0", 9600, listener);
            //ino.arduinoTX("/dev/ttyACM0", 9600);
            ///ino.sendByte(64);
            ino.sendData("5");
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(JavaRX_multiTest001.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}