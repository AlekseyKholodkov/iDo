package com.kholodkov.ido.task;

import com.kholodkov.ido.config.SpringApplicationContext;
import com.kholodkov.ido.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@ContextConfiguration(classes = SpringApplicationContext.class)
@TestExecutionListeners
public class TaskDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private TaskDao taskDao;

    @Test
    @Commit
    @Transactional
    public void insertTaskTest() throws Exception {
        Task task = new Task("Task test insert");
        taskDao.insertTask(task);
    }

    @Test
    @Commit
    @Transactional
    public void insertTaskVsSubTasks() {
        Task task = new Task("Super task test insert");
        Task subTask1 =new Task("first sub task");
        Task subTask2 =new Task("second sub task");

        taskDao.insertTask(task);
        taskDao.insertTask(subTask1);
        taskDao.insertTask(subTask2);

        task.getSubTasks().add(subTask1);
        task.getSubTasks().add(subTask2);
        subTask1.setSuperTask(task);
        subTask2.setSuperTask(task);
    }

    @Test
    public void selectTaskTest() throws Exception {

    }

    @Test
    public void deleteTaskTest() throws Exception {

    }
}