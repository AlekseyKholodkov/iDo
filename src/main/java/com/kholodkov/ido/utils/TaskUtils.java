package com.kholodkov.ido.utils;

import com.kholodkov.ido.task.Task;

public interface TaskUtils {
    Task createTask(String task);
    Task retrieveTask(long id);
    Task updateTask(long id, String newTask);
    void deleteTask(long id);
}
