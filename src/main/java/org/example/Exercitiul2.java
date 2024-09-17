package org.example;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercitiul2 {

    public static final String PING = "Ping";
    public static final String PONG = "Pong";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            playPingPong(executor);
        }
    }

    public static List<String> playPingPong(ExecutorService executor) throws ExecutionException, InterruptedException {
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
