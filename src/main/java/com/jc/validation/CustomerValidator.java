package com.jc.validation;

import com.jc.model.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (target instanceof Customer customer) {
            if (customer.getCategory().isEmpty()) {
                errors.rejectValue("category", "category.blank");
            }
        }
    }

}
