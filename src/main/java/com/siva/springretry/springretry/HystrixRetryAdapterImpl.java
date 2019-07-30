package com.siva.springretry.springretry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HystrixRetryAdapterImpl implements HystrixRetryAdapter {

    @Autowired
    UserHystrixService userHystrixService;

    @Override
    @Retryable(value = { RemoteServiceNotAvailableException.class }, maxAttemptsExpression = "#{${my.app.maxAttempts}}", backoff = @Backoff(delayExpression = "#{${my.app.backOffDelay}}"))
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback){
        return userHystrixService.getBackendResponse(simulateretry, simulateretryfallback);

    }

    @Override
    @Recover
    public String getBackendResponseFallback(Throwable throwable, boolean simulateretry, boolean simulateretryfallback) {
        System.out.println("All retries completed, so Fallback method called!!!");
        log.info("All retries completed, simulateretry {}, simulateretryfallback {}", simulateretry,simulateretryfallback);
        System.out.println("Error Class :: " + throwable.getClass().getName());
        return "All retries completed, so Fallback method called!!!";
    }

}
