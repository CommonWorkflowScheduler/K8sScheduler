package cws.scheduler.scheduler.nodeassign;

import cws.scheduler.model.NodeWithAlloc;
import cws.scheduler.model.Requirements;
import cws.scheduler.model.Task;
import cws.scheduler.scheduler.Scheduler;
import cws.scheduler.util.NodeTaskAlignment;

import java.util.List;
import java.util.Map;

public abstract class NodeAssign {

    Scheduler scheduler;

    public abstract List<NodeTaskAlignment> getTaskNodeAlignment( List<Task> unscheduledTasks, Map<NodeWithAlloc, Requirements> availableByNode );

    public void registerScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }


}
