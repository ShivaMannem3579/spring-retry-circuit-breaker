package com.siva.springretry.springretry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MyRestController {

    @Autowired
    RetryAdapter retryAdapter;

    @Autowired
    RetryCircuitAdapter retryCircuitAdapter;

    @Autowired
    HystrixAdapter  hystrixAdapter;

    @Autowired
    HystrixRetryAdapter  hystrixRetryAdapter;

    @GetMapping("/retry")
    public String validateSPringRetryCapability(@RequestParam(required = false) boolean simulateretry,
                                                @RequestParam(required = false) boolean simulateretryfallback) throws RemoteServiceNotAvailableException {
        log.info("===============================");
        log.info("Inside RestController validateSPringRetryCapability method..");

        return retryAdapter.getBackendResponse(simulateretry, simulateretryfallback);
    }



    @GetMapping("/retrycircuit")
    public String validateSPringRetryWithCircuitBreakerCapability(@RequestParam(required = false) boolean simulateretry,
                                   @RequestParam(required = false) boolean simulateretryfallback)  throws RemoteServiceNotAvailableException {
        log.info("===============================");
        log.info("Inside RestController validateSPringRetryWithCircuitBreakerCapability method..");
        return retryCircuitAdapter.getBackendResponse(simulateretry, simulateretryfallback);
    }



    @GetMapping("/hystrix")
    public String validateHystrixCapability(@RequestParam(required = false) boolean simulateretry,
                                                                  @RequestParam(required = false) boolean simulateretryfallback)  throws RemoteServiceNotAvailableException {
        log.info("===============================");
        log.info("Inside RestController validateHystrixCapability method..");
        return hystrixAdapter.getBackendResponse(simulateretry, simulateretryfallback);
    }



    @GetMapping("/hystrixretry")
    public String validateHystrixRetryCapability(@RequestParam(required = false) boolean simulateretry,
                                            @RequestParam(required = false) boolean simulateretryfallback)  throws RemoteServiceNotAvailableException {
        log.info("===============================");
        log.info("Inside RestController validateHystrixRetryCapability method..");
        return hystrixRetryAdapter.getBackendResponse(simulateretry, simulateretryfallback);
    }

}
