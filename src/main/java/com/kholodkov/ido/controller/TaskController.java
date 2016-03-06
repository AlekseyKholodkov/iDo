package com.kholodkov.ido.controller;

import com.kholodkov.ido.task.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TaskController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public Task task() {
        return new Task("Task Controller");
    }
}
