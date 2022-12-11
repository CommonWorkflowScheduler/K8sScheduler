package cws.scheduler.scheduler.prioritize;

import cws.scheduler.model.Task;

import java.util.List;

public interface Prioritize {

    void sortTasks( List<Task> tasks);

}
