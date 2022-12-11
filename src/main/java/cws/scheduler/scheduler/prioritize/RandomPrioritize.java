package cws.scheduler.scheduler.prioritize;

import cws.scheduler.model.Task;

import java.util.Collections;
import java.util.List;

public class RandomPrioritize implements Prioritize {

    @Override
    public void sortTasks( List<Task> tasks ) {
        Collections.shuffle( tasks );
    }

}
