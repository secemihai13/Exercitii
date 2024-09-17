package org.example;

import lombok.Getter;
import org.example.service.PingPong;
import org.example.service.impl.PingPongImpl;

import java.util.concurrent.Executors;

@Getter
public class Exercitiul2 {

    private final PingPong pingPong;

    public Exercitiul2(PingPong pingPong) {
        this.pingPong = pingPong;
    }

    public static void main(String[] args) {
        var exercitiul2 = new Exercitiul2(new PingPongImpl(Executors.newFixedThreadPool(2)));
        exercitiul2.getPingPong().play();
    }
}
