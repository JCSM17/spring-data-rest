package com.jc;

import com.jc.model.Address;
import com.jc.model.Customer;
import com.jc.repository.AddressRepository;
import com.jc.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App.class, args);
        var customerRepo = ctx.getBean(CustomerRepository.class);
        var addressRepo = ctx.getBean(AddressRepository.class);

        var addr1 = new Address(null, "New York");
        var addr2 = new Address(null, "Los Angeles");
        var addr3 = new Address(null, "Chicago");
        addressRepo.saveAll(List.of(addr1, addr2, addr3));

        var cust1 = new Customer(null, "cust1@gmail.com", "dept1", "cat1", addr1);
        var cust2 = new Customer(null, "cust2@gmail.com", "dept2", "cat2", addr2);
        var cust3 = new Customer(null, "cust3@gmail.com", "dept2", "cat3", addr3);
        customerRepo.saveAll(List.of(cust1, cust2, cust3));


    }

}
