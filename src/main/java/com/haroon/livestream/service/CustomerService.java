package com.haroon.livestream.service;



import com.haroon.livestream.mock.MockCustomerRepo;
import com.haroon.livestream.model.Customer;
import com.haroon.livestream.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerService {

    private final MockCustomerRepo mockCustomerRepo;

    private final CustomerRepository customerRepository;
    @Autowired
    @Qualifier("jdbcScheduler")
    private Scheduler jdbcScheduler;

    public Flux<Customer> getCustomers() {
        log.info("getting customers");
        Flux<Customer> defer = Flux.defer(() -> Flux.fromIterable(customerRepository.findAll()));
        return defer.subscribeOn(jdbcScheduler);
    }
}
