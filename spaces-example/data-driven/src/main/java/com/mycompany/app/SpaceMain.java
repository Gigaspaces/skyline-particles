package com.mycompany.app;

import org.slf4j.*;
import javax.annotation.*;
import org.springframework.stereotype.Component;

import org.openspaces.core.*;
import org.openspaces.core.cluster.*;

@Component
public class SpaceMain {
    private static final Logger logger = LoggerFactory.getLogger(SpaceMain.class);
    private static final String SPACE_NAME = "demo";

    @Resource
    private GigaSpace gigaSpace;

    @ClusterInfoContext
    private ClusterInfo clusterInfo;


    @PostConstruct
    public void initialize() {
        // Get the space instance (similar to a database in RDBMS)
        GigaSpace space = gigaSpace.getClustered();

        // writing to the Account type (similar to table) using gigaspaces SDK
        // space.write(new Account(12345678, 100, "SAVINGS", "240317"));
    }
}
