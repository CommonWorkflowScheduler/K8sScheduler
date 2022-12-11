package cws.scheduler.client;

import cws.scheduler.model.NodeWithAlloc;

public interface Informable {

    void informResourceChange();
    void newNode( NodeWithAlloc node );
    void removedNode( NodeWithAlloc node );


}
