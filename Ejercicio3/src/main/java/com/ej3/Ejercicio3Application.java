package com.ej3;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@SpringBootApplication
public class Ejercicio3Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Observable<String> messageSender = Observable.just("Mensaje1", "Mensaje2", "Mensaje3");

        IntStream it = IntStream.range(0, 3);

        it.forEach(n -> {
            String observerName = "Observer" + n;

            messageSender.subscribe(new Observer() {

                @Override
                public void onSubscribe(@NonNull Disposable disposable) {

                    System.out.println(observerName + " Suscribed");
                }

                @Override
                public void onNext(@NonNull Object o) {
                    System.out.println(observerName + " Received" + o);

                }

                @Override
                public void onError(@NonNull Throwable throwable) {
                    System.out.println(observerName + " Error" + throwable.getMessage());

                }

                @Override
                public void onComplete() {
                    System.out.println(observerName + " Complete");

                }
            });

        });

    }
}
