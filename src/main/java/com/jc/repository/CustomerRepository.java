package com.jc.repository;


import com.jc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // http://localhost:8080/customers/search/find-by-email?email=cust1@gmail.com
    List<Customer> findByEmail(String email);

    // http://localhost:8080/customers/search/email-starts?email=cust1
    @RestResource(path = "email-start", rel = "email-starts")
    List<Customer> findByEmailStartsWith(String email);

    // http://localhost:8080/customers/search/category-department?category=cat1&dept=dept2
    @RestResource(path = "category-dept", rel = "category-dept")
    List<Customer> findByAndDept(String category, String department);

    // http://localhost:8080/customers/search/category-dept-in?category=cat1&dept=dept1&dept=dept2
    @RestResource(path = "category-dept-in", rel = "category-dept-in")
    List<Customer> findByCategoryAndDeptIn(String category, List<String> dept);


}
