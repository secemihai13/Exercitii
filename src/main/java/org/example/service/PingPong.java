package org.example.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface PingPong {

    List<String> play() throws ExecutionException, InterruptedException;
}
