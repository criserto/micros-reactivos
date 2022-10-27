package com.ej4;

import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

@SpringBootApplication
public class Ejercicio4Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Flux<String> messageSender = Flux.just("Mensaje1", "Mensaje2", "Mensaje3");
        IntStream it = IntStream.range(0, 3);
        it.forEach(n -> {
            //NOMBRE DEL OBSERVADOR
            String observerName = "Observer " + n;
            // RECIBED ->  RECIBE MENSAJE
            // ERR -> SI ENCUENTRA ALGÚN ERROR
            messageSender.subscribe(recibed -> System.out.println(observerName + " Suscribe " + recibed),
                                    err -> System.out.println(observerName + " Error " + err.getMessage()));
        });


    }
}
