package com.kholodkov.ido.dao;

import com.kholodkov.ido.task.Task;

public interface TaskDao {
    public void insertTask(Task task);
    public Task selectTask(long id);
    public void deleteTask(long id);
}
