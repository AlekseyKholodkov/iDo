package com.kholodkov.ido.task;

import org.testng.Assert;
import org.testng.annotations.*;
import com.kholodkov.ido.state.TaskState;

@Test
public class TaskTest {

    private Task task;
    @BeforeMethod
    public void getNewTask() {
     this.task = new Task("My test com.kholodkov.task");
    }

    public void newUserCanSeeStartTask() {
        Assert.assertEquals(task.getTitle(), "My test com.kholodkov.task");
        task.setTitle("New text");
        Assert.assertEquals(task.getTitle(), "New text");
    }

    @Test
    public void newTaskInitializeInStateWIllBeDone() {
        Assert.assertEquals(task.getState(), TaskState.OPEN);
    }

    @Test
    public void newTaskHasEmptySubTasks() {
        Assert.assertEquals(task.getSubTasks().size(), 0);
    }

    @Test
    public void toStringWorkCorrect() {
        Assert.assertNotNull(task.toString());
    }

    @Test
    public void addSubTask() {
        task.getSubTasks().add(new Task("Sub Task"));
        Assert.assertEquals(task.getSubTasks().get(0).getTitle(), "Sub Task");
    }
}
