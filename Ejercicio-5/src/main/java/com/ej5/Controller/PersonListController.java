package com.ej5.Controller;

import com.ej5.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class PersonListController {

    @GetMapping(path="/person-list-1")
    public Flux<Person> personList1(){

        Flux<Person> persona1 = Flux.just(new Person("Cristian", "González", 30))
                .delayElements(Duration.ofSeconds(1));

        return persona1;
    }

    @GetMapping(path="/person-list-2")
    public Flux<Person> personList2(){
        Flux<Person> persona2 = Flux.just(new Person("Mari Carmen", "López", 29))
                .delayElements(Duration.ofSeconds(1));

        return persona2;
    }

    @GetMapping(path="/person-list-3")
    public Flux<Person> personList3(){
        Flux<Person> persona3 = Flux.just(new Person("Javier", "González", 29))
                .delayElements(Duration.ofSeconds(1));

        return persona3;
    }

    @GetMapping(path="/person-list-4")
    public Flux<Person> personList4(){
        Flux<Person> persona4 = Flux.just(new Person("Carlos", "López", 30))
                .delayElements(Duration.ofSeconds(1));

        return persona4;
    }

}
