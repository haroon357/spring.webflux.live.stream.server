package com.haroon.livestream.service;



import com.haroon.livestream.mock.MockCustomerRepo;
import com.haroon.livestream.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerService {

    private final MockCustomerRepo mockCustomerRepo;

    public Flux<Customer> getCustomers() {
        log.info("getting customers");
        return mockCustomerRepo.getCustomers();
    }
}
