package com.kholodkov.ido.utils;

import com.kholodkov.ido.task.Task;
import com.kholodkov.ido.utils.TaskUtils;

public class TaskUtilsImpl implements TaskUtils {
    @Override
    public Task createTask(String task) {
        return new Task(task);
    }

    @Override
    public Task retrieveTask(long id) {
        return null;
    }

    @Override
    public Task updateTask(long id, String newTask) {
        return null;
    }

    @Override
    public void deleteTask(long id) {
    }
}
