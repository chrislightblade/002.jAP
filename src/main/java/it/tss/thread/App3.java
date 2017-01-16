/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO code application logic here

        System.out.println("program start....." + System.currentTimeMillis());
        
        Callable<String> messageProvider = App3::getMessage;
        List<Future<String>> results = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(10);//consente di svolgere più thread assieemsenza crashaer la macchina, ottimizza la gestione del multithread---nella parentesi quanti assieme alla volta
        for (int i = 0; i < 100; i++) {
            Future<String> result = pool.submit(messageProvider);//gli dico di aspettare il risultato del processo precedente --> perdiamo la sincronia di più processi paralleli
            results.add(result);
            System.out.println(result);
        }
        
        for (Future<String> result : results) {
            System.out.println("---" + result.get()); 
        }
        
        pool.shutdown();
    }

    public static String getMessage() {
        try {

            Thread.sleep(2000);
            

        } catch (InterruptedException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "--------work in progrewss..." + System.currentTimeMillis();

    }

}
