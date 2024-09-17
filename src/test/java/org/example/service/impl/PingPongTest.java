package org.example.service.impl;

import org.example.service.PingPong;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import static org.example.service.impl.PingPongImpl.PING;
import static org.example.service.impl.PingPongImpl.PONG;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PingPongTest {

    private final PingPong underTest = new PingPongImpl(Executors.newFixedThreadPool(2));

    @Test
    void playPingPong() throws ExecutionException, InterruptedException {
        List<String> printMessages = this.underTest.play();

        for (int i = 0; i < printMessages.size(); i++) {
            if (i % 2 == 0) {
                assertEquals(PING, printMessages.get(i));
            } else {
                assertEquals(PONG, printMessages.get(i));
            }
        }
    }
}
