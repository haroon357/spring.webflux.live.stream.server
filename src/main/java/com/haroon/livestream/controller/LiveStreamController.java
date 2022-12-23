package com.haroon.livestream.controller;

import com.haroon.livestream.model.Customer;
import com.haroon.livestream.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LiveStreamController {

    private final CustomerService customerService;

    @GetMapping(value = "/customer", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomersAsLiveStream() {
        return customerService.getCustomers()
                .doOnNext(c -> log.info(c.toString()));
    }

    @GetMapping(value = "/customerwithdelay", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomersAsLiveStreamWithDelay() {
        return customerService.getCustomers()
                .doOnNext(c -> log.info(c.toString()))
                .delayElements(Duration.ofSeconds(1));
    }
//    @GetMapping(value = "/temperatures", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Integer> getTemperature() {
//        Random r = new Random();
//        int low = 0;
//        int high = 50;
//        return Flux.fromStream(Stream.generate(() -> r.nextInt(high - low) + low)
//                        .map(s -> String.valueOf(s))
//                        .peek((msg) -> {
//                            log.info(msg);
//                        }))
//                .map(s -> Integer.valueOf(s))
//                .delayElements(Duration.ofSeconds(1));
//    }



}
