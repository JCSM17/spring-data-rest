package com.jc.handler;

import com.jc.model.Customer;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CustomerEventHandler {

    @HandleBeforeCreate
    public void handleBeforeCreate(Customer customer) {
        System.out.println("HandleBeforeCreate " + customer);
    }
}
