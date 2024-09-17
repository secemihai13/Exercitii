package org.example.service.impl;

import lombok.SneakyThrows;
import org.example.service.PingPong;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class PingPongImpl implements PingPong {

    public static final String PING = "Ping";
    public static final String PONG = "Pong";

    private final ExecutorService executor;

    public PingPongImpl(ExecutorService executor) {
        this.executor = executor;
    }

    @SneakyThrows
    public List<String> play() {
        List<String> printMessages = new ArrayList<>(500_000);
        long startTime = System.currentTimeMillis();

        while (startTime > System.currentTimeMillis() - 5000) {
            CompletableFuture<String> ping = CompletableFuture.supplyAsync(() -> consolePrint(PING), executor);
            CompletableFuture<String> pong = CompletableFuture.supplyAsync(() -> consolePrint(PONG), executor);

            CompletableFuture.allOf(ping, pong).join();

            printMessages.add(ping.get());
            printMessages.add(pong.get());
        }

        return printMessages;   // The returned list is used in unit testing.
    }

    private static synchronized String consolePrint (String message) {
        System.out.println(message);
        return message;
    }
}
