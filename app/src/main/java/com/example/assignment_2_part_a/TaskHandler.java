package com.example.assignment_2_part_a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskHandler implements Runnable{
    @Override
    public void run() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }
}
