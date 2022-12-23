package com.haroon.livestream.mock;

import com.haroon.livestream.model.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
public class MockCustomerRepo {

    public Flux<Customer> getCustomers() {
        return Flux.just(
                buildMockCustomerObj("Haroon","Chaudhary"),
                buildMockCustomerObj("Jo","Do"),
                buildMockCustomerObj("Jon","Ho")
        );
    }

    private Customer buildMockCustomerObj(String firstName, String lastName) {
        return Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .id(UUID.randomUUID().toString())
                .build();
    }
}
