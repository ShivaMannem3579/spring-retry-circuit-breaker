package com.siva.springretry.springretry;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserHystrixService {

    @HystrixCommand
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback) throws RemoteServiceNotAvailableException {
        if (simulateretry) {
            System.out.println("Simulateretry is true, so try to simulate exception scenerio.");

            if (simulateretryfallback) {
                throw new RemoteServiceNotAvailableException(
                        "Don't worry!! Just Simulated for Spring-retry..Must fallback as all retry will get exception!!!");
            }
            int random = new Random().nextInt(4);

            System.out.println("Random Number : " + random);
            if (random % 2 == 0) {
                throw new RemoteServiceNotAvailableException("Don't worry!! Just Simulated for Spring-retry..");
            }
        }

        return "Hello from Remote Backend!!!";
    }
}
