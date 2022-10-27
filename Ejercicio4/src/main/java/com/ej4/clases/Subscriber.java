package com.ej4.clases;

public class Subscriber {
    public static void print(Integer n) {

        //DESCOMENTAR Y USARÁ HILOS
        //System.out.println("Subscriber 1: " + n);

        //SIMULACIÓN DE UNA PETICIÓN ASINCRONA
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Subscriber 1: " + n);


    }
}
