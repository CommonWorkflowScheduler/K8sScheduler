package cws.scheduler.util;

import cws.scheduler.model.NodeWithAlloc;
import cws.scheduler.model.Task;

public class NodeTaskAlignment {

    public final NodeWithAlloc node;
    public final Task task;

    public NodeTaskAlignment( NodeWithAlloc node, Task task ) {
        this.node = node;
        this.task = task;
    }
}
