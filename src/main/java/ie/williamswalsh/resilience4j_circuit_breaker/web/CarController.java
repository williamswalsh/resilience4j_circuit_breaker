package ie.williamswalsh.resilience4j_circuit_breaker.web;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    public static String CAR_SERVICE = "carService";

    public static int noOfTries = 0;

    @GetMapping(value="/")
    @CircuitBreaker(name = "CAR_SERVICE", fallbackMethod = "getCarFallback")
    public String getCar() {
        noOfTries++;

        // The purpose of this is to conditionally cause the fallback method to be called.
        if(noOfTries < 5) throw new RuntimeException("This is an exception, to simulate a failure in an upstream service.");
        return "Ferrari";
    }

    public String getCarFallback(Exception e) {
        return "Fallback - Ferrari";
    }
}

