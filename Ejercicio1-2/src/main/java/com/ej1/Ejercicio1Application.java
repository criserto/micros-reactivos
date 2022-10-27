package com.ej1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

		AtomicInteger count = new AtomicInteger();
		numbers.forEach(n->{
			if(n>10){
				count.getAndIncrement();
			}
		});

		System.out.println(count);

		//OTRA FORMA MÁS TRADICIONAL
		int count1=0;
		for(Integer x : numbers){
			if(x>10){
				count1++;
			}
		}
		System.out.println(count1);

		//OTRA FORMA AÚN MÁS VIEJA
		int count2 = 0;
		for (int i = 0; i <numbers.size(); i++) {
			if(numbers.get(i)>10){
				count2++;
			}
		}
		System.out.println(count2);
	}

}
