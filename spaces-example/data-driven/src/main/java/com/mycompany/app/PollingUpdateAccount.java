package com.mycompany.app;

import org.openspaces.core.GigaSpace;
import org.openspaces.events.EventDriven;
import org.openspaces.events.EventTemplate;
import org.openspaces.events.adapter.SpaceDataEvent;
import org.openspaces.events.polling.Polling;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.logging.Logger;

@EventDriven
@Polling
public class PollingUpdateAccount {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private GigaSpace space;

    @EventTemplate
    Account unprocessedData() {
        // The rule - if the account type is "SAVINGS"
        Account account = new Account();
        account.setAccountType("SAVINGS");
        return account;
    }

    @SpaceDataEvent
    public Account eventListener(Account account) throws IOException {
        // Execute the rule action - update the district id
        account.setDistrictId(333);
        return account;
    }
}
