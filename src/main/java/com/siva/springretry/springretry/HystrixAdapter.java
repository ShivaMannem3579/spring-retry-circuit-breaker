package com.siva.springretry.springretry;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public interface HystrixAdapter {

    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback) throws RemoteServiceNotAvailableException;

}
