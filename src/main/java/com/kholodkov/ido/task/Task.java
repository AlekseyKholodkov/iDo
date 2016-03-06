package com.kholodkov.ido.task;

import com.kholodkov.ido.state.TaskState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Enumerated(EnumType.STRING)
    private TaskState state = TaskState.OPEN;

    @ManyToOne
    private Task superTask;

    @OneToMany(mappedBy = "superTask", fetch = FetchType.LAZY)
    private List<Task> subTasks = new ArrayList<>();

    public Task() {
    }

    public Task(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String task) {
        this.text = task;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public Task getSuperTask() {
        return superTask;
    }

    public void setSuperTask(Task superTask) {
        this.superTask = superTask;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks.addAll(subTasks);
    }

    @Override
    public String toString() {
        return  "id=" + id + ", " +
                "task=" + text + ", " +
                "taskState=" + state + ", " +
                "superTask=" + superTask + ", " +
                "subTasks=" + subTasks + ".";
    }
}
