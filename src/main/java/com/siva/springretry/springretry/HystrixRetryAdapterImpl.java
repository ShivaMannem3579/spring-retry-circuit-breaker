package com.siva.springretry.springretry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HystrixRetryAdapterImpl implements HystrixRetryAdapter {

    @Autowired
    UserHystrixService userHystrixService;

    @Override
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback) throws RemoteServiceNotAvailableException {
        return userHystrixService.getBackendResponse(simulateretry, simulateretryfallback);

    }

    @Override
    public String getBackendResponseFallback(RuntimeException e) {
        System.out.println("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";
    }

}
