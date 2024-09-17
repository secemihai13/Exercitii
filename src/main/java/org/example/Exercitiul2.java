package org.example;

import lombok.Getter;
import org.example.service.PingPong;
import org.example.service.impl.PingPongImpl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@Getter
public class Exercitiul2 {

    private final PingPong pingPong;

    public Exercitiul2(PingPong pingPong) {
        this.pingPong = pingPong;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (var executor = Executors.newFixedThreadPool(2)) {
            var exercitiul2 = new Exercitiul2(new PingPongImpl(executor));
            exercitiul2.getPingPong().play();
        }
    }
}
