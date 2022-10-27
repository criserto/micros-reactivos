package com.ej1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class Ejercicio1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//EJERCICIO 1, MOSTRAR CUANTOS NÚMEROS SON MAYORES DE 10 (FUNCIONAL)
		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		System.out.println(numbers.stream().filter(n->n>10).count());

		//EJERCICIO 1, MOSTRAR CUANTOS NÚMEROS SON MAYORES DE 10 (IMPERATIVA)


	}

}
