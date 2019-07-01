package com.siva.springretry.springretry;

public interface HystrixRetryAdapter {


    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback);


    public String getBackendResponseFallback(Throwable throwable);

}
