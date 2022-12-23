package com.haroon.livestream.mock;

import com.haroon.livestream.model.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;


@Service
public class MockCustomerRepo {

    public Flux<Customer> getCustomers(int count) {
        return Flux.range(1,count)
                .map(i ->  buildMockCustomerObj(i,"Jon"+i,"Ho"+i));

    }

    private Customer buildMockCustomerObj(int count, String firstName, String lastName) {
        Random random = new Random();
        return Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .id(random.nextLong()+count)
                .build();
    }
}
