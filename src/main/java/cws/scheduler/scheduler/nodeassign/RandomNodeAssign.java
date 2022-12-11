package cws.scheduler.scheduler.nodeassign;

import cws.scheduler.model.NodeWithAlloc;
import cws.scheduler.model.PodWithAge;
import cws.scheduler.model.Requirements;
import cws.scheduler.model.Task;
import cws.scheduler.util.NodeTaskAlignment;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class RandomNodeAssign extends NodeAssign {

    @Override
    public List<NodeTaskAlignment> getTaskNodeAlignment( List<Task> unscheduledTasks, Map<NodeWithAlloc, Requirements> availableByNode ) {
        LinkedList<NodeTaskAlignment> alignment = new LinkedList<>();
        final ArrayList<Map.Entry<NodeWithAlloc, Requirements>> entries = new ArrayList<>( availableByNode.entrySet() );
        for ( final Task task : unscheduledTasks ) {
            final PodWithAge pod = task.getPod();
            log.info("Pod: " + pod.getName() + " Requested Resources: " + pod.getRequest() );
            Collections.shuffle( entries );
            boolean assigned = false;
            for ( Map.Entry<NodeWithAlloc, Requirements> e : entries ) {
                final NodeWithAlloc node = e.getKey();
                if ( scheduler.canSchedulePodOnNode( availableByNode.get( node ), pod, node ) ) {
                    alignment.add(new NodeTaskAlignment( node, task));
                    availableByNode.get( node ).subFromThis(pod.getRequest());
                    log.info("--> " + node.getName());
                    assigned = true;
                    break;
                }
            }
            if ( !assigned ) {
                log.trace( "No node with enough resources for {}", pod.getName() );
            }
        }
        return alignment;
    }

}
