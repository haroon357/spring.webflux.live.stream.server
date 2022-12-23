package com.haroon.livestream.controller;

import com.haroon.livestream.mock.MockCustomerRepo;
import com.haroon.livestream.model.Customer;
import com.haroon.livestream.repository.CustomerRepository;
import com.haroon.livestream.service.CustomerService;
import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LoadMockDataInDBController {

    private final MockCustomerRepo mockCustomerRepo;

    private final CustomerRepository customerRepository;

    @GetMapping(value = "/load")
    public String load(@RequestParam Integer count) {
        mockCustomerRepo.getCustomers(Integer.valueOf(count))
                .doOnNext(customerRepository::save)
                .subscribe();

        return "SUCCESS";
    }

}
