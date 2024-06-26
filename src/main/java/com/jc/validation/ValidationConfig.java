package com.jc.validation;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class ValidationConfig implements RepositoryRestConfigurer {

    @Override
    public void configureValidatingRepositoryEventListener(
            ValidatingRepositoryEventListener validatingListener
    ) {
        validatingListener.addValidator("beforeCreate", new CustomerValidator());
    }
}
