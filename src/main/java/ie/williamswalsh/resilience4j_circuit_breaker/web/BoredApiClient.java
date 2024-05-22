package ie.williamswalsh.resilience4j_circuit_breaker.web;

import ie.williamswalsh.resilience4j_circuit_breaker.model.Activity;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class BoredApiClient {

    private final static String BORED_ACTIVITY_API = "https://www.boredapi.com/api/activity/";

    private final static String ACTIVITY_SERVICE = "activity_service_circuit_breaker";

    RestTemplate restTemplate;


    public BoredApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "ACTIVITY_SERVICE", fallbackMethod = "getFallbackActivity")
    public String getActivity() {
        ResponseEntity<Activity> response = restTemplate.getForEntity(BORED_ACTIVITY_API, Activity.class);
        Activity activity = response.getBody();
        assert activity != null;

        return activity.activity();
    }

    public String getFallbackActivity(Throwable t) {
        System.out.println("Throwable passed to fallback method: " + t);
        return "Go read a book.";
    }
}
