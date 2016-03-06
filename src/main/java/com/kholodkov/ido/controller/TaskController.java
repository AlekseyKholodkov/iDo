package com.kholodkov.ido.controller;

import com.kholodkov.ido.task.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TaskController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/task")
    public Task task() {
        return new Task("Task Controller");
    }
}