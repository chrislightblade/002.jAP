/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        
        Thread th = new Thread(App::doWork);/*(new Runnable() {//implementazione ''al volo'' di una interfaccia --> metto il codice da eseguire in parallelo 
            @Override
            public void run() {                
                for (long i = 0; i < Long.MAX_VALUE; i++) {
                System.out.println("-------------------------------other work in progrewss..." + System.currentTimeMillis());//tempo corrente in millisecondi
                }
            }
        });*/
        th.start();
        
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            
            System.out.println("--main work in progrewss..." + System.currentTimeMillis());//tempo corrente in millisecondi
                        
        }
        
    }
    
    public static void doWork(){
        for (long i = 0; i < Long.MAX_VALUE; i++) {
                System.out.println("-------------------------------other work in progrewss..." + System.currentTimeMillis());//tempo corrente in millisecondi
                }
    }
       
}
