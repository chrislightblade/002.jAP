/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread;

import it.tss.thread.App;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("program start....." + System.currentTimeMillis());

        Thread th1 = new Thread(App1::doWork);//posso scriverlo = new Thread(App1::doWork).start();

        th1.start();

    }

    public static void doWork() {
        try {
            for (int i = 0; i < 10; i++) {//for che crea x processi assieme
                Thread.sleep(1000);
                System.out.println(i);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("--------work in progrewss..." + System.currentTimeMillis());//tempo corrente in millisecondi

    }
}
