/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("program start....." + System.currentTimeMillis());
        
        ExecutorService pool = Executors.newFixedThreadPool(10);//consente di svolgere più thread assieemsenza crashaer la macchina, ottimizza la gestione del multithread---nella parentesi quanti assieme alla volta
        for (int i = 0; i < 100; i++) {
            pool.submit(App2::doWork);
        }
    }
    
    
    public static void doWork() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("--------work in progrewss..." + System.currentTimeMillis());//tempo corrente in millisecondi

    }
    
}
