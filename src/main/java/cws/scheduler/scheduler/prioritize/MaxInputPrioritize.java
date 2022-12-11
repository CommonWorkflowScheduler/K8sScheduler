package cws.scheduler.scheduler.prioritize;

import cws.scheduler.model.Task;

import java.util.Comparator;
import java.util.List;

public class MaxInputPrioritize implements Prioritize {

    @Override
    public void sortTasks( List<Task> tasks ) {
        tasks.sort( Comparator.comparing( Task::getInputSize ).reversed() );
    }

}
