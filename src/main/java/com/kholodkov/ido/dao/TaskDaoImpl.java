package com.kholodkov.ido.dao;

import com.kholodkov.ido.task.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TaskDaoImpl implements TaskDao {
    private static final Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insertTask(Task task) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(task);
        logger.info("Task insert successfully, Task=" + task);
    }

    @Override
    public Task selectTask(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Task task = session.load(Task.class, id);
        logger.info("Task loaded successfully, Task=" + task);
        return task;
    }

    @Override
    public void deleteTask(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Task task = session.load(Task.class, id);
        if (task != null) session.delete(task);
        logger.info("Task deleted successfully, Task=" + task);
    }
}
