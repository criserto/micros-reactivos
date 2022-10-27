package com.ej4.Controller;

import com.ej4.clases.Subscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class Controller {

    @GetMapping (value = "/numbers", produces = "text/event-stream")
    public Flux<Integer> numbers(){

        //USAR Flux.range(INICIO, FINAL) --> ME AHORRO EL ROLLO DE PONER NÚMEROS
        Flux<Integer> flux = Flux.just(1,2,3,4,5,6,7,8,9,10).delayElements(Duration.ofSeconds(1));

        return flux;
    }

    @GetMapping(path = "/numbers-with-subscribers", produces = "text/event-stream")
    public Flux<Integer> numbersWithSubscribers() {
        Flux<Integer> flux = Flux.range(1, 30).delayElements(Duration.ofSeconds(1));

        //IMPRIME EN CONSOLA SUBSCRIBER 1*
        flux.subscribe(n -> Subscriber.print(n)); // Suscriptor 1

        //IMPRIME EN CONSOLA SUBSCRIBER 2*
        flux.subscribe(n -> System.out.println("Subscriber 2: " + n)); // Suscriptor 2

        //POSIBLE USO DE HILOS AL NO IR ORDENADOS, PRIMERO MOSTRAR UNO Y LUEGO OTRO. CONFIRMADO EN LA SEGUNDA ETAPA DEL EJ

        return flux;
    }


}
