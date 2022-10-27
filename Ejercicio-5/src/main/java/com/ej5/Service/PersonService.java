package com.ej5.Service;

import com.ej5.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@Service
public class PersonService {

    public Flux<Person> allPerson() {

        Flux<Person> persona1 = WebClient.create("http://localhost:8080/person-list-1").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> persona2 = WebClient.create("http://localhost:8080/person-list-2").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> persona3 = WebClient.create("http://localhost:8080/person-list-3").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> persona4 = WebClient.create("http://localhost:8080/person-list-4").get().retrieve().bodyToFlux(Person.class);

        Flux<Person> allFlux = Flux.merge(persona1, persona2, persona3, persona4);

        return allFlux;
    }
}
