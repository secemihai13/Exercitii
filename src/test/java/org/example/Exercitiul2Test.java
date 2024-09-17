package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.Exercitiul2.PING;
import static org.example.Exercitiul2.PONG;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercitiul2Test {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    @Test
    void playPingPong() throws ExecutionException, InterruptedException {
        List<String> printMessages = Exercitiul2.playPingPong(this.executor);

        for (int i = 0; i < printMessages.size(); i++) {
            if (i % 2 == 0) {
                assertEquals(PING, printMessages.get(i));
            } else {
                assertEquals(PONG, printMessages.get(i));
            }
        }
    }
}
